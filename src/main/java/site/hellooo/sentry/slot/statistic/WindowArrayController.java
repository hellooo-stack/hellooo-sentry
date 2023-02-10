package site.hellooo.sentry.slot.statistic;

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

    public WindowWrap<T> currentWindow() {
        long now = System.currentTimeMillis();



    }

}
