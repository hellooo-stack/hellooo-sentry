package site.hellooo.sentry.slot.statistic;

/**
 * @author Jeb.Wang
 * Time: 2023/2/8 10:25:10
 */
public class WindowWrap<T extends DataBucket> {
    private long windowStart;
    private T value;

    public WindowWrap(long windowStart, T value) {
        this.windowStart = windowStart;
        this.value = value;
    }

    public void resetTo(long newWindowStart) {
        this.windowStart = windowStart;
    }

    public long getWindowStart() {
        return windowStart;
    }

    public void setWindowStart(long windowStart) {
        this.windowStart = windowStart;
    }

    public T value() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
