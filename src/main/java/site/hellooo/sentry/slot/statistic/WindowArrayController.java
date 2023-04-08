package site.hellooo.sentry.slot.statistic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jeb.Wang
 * Time: 2023/2/7 19:41:45
 */
public abstract class WindowArrayController<T extends DataBucket> {

    private long windowLengthInMs;

    private long intervalInMs;

    private AtomicReferenceArray<WindowWrap<T>> samples;

    private Lock updateLock = new ReentrantLock();

    public WindowArrayController(int sampleCount, long intervalInMs) {
        this.intervalInMs = intervalInMs;
        this.windowLengthInMs = intervalInMs / sampleCount;
        this.samples = new AtomicReferenceArray<WindowWrap<T>>(sampleCount);
    }

    /**
     * 获取当前时间窗口
     */
    public WindowWrap<T> currentWindow() {
        long now = System.currentTimeMillis();
        int idx = getIdx(now);
//        ---- ---- --
//                 <- curWindowStart 在这里
        long curWindowStart = getCurWindowStart(now);
        WindowWrap<T> window = null;
        while (window == null) {
            window = samples.get(idx);
            if (window == null) {
                // set new window
                WindowWrap<T> newWindow = new WindowWrap<T>(curWindowStart, newEmptyBucket());
                if (!samples.compareAndSet(idx, null, newWindow)) {
                    Thread.yield();
                }
            } else if (window.getWindowStart() != curWindowStart) {
                if (updateLock.tryLock()) {
                    try {
                        // 重置窗口以开始下一个数据收集周期
                        window.resetTo(curWindowStart);
                        window.value().reset();
                    } finally {
                        updateLock.unlock();
                    }
                } else {
                    Thread.yield();
                }
            }
        }
        return window;
    }

    /**
     * 初始化一个新的数据桶
     */
    protected abstract T newEmptyBucket();

    /**
     * 获取所有有效窗口
     */
    public List<T> windows() {
        List<T> windows = new ArrayList<T>();
        for (int i = 0; i < samples.length(); i++) {
            WindowWrap<T> window = samples.get(i);
            if (window != null && !isDeprecated(window)) {
                windows.add(window.value());
            }
        }
        return windows;
    }

    /**
     * 窗口是否过期(窗口开始时间超过了设定的间隔时间则为过期)
     */
    private boolean isDeprecated(WindowWrap<T> window) {
        long now = System.currentTimeMillis();
        return (now - window.getWindowStart()) > intervalInMs;
    }

    /**
     * 获取时间窗口开始时间
     */
    private long getCurWindowStart(long now) {
        return now - (now % windowLengthInMs);
    }

    /**
     * 根据时间获取数组下标
     */
    private int getIdx(long time) {
        long timeId = time / windowLengthInMs;
        return (int) (timeId % samples.length());
    }

    public long getIntervalInSec() {
        return intervalInMs / 1000;
    }
}
