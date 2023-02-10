package site.hellooo.sentry.slot.statistic;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author Jeb.Wang
 * Time: 2023/2/8 10:26:27
 */
public class MetricBucket implements DataBucket {

    private LongAdder[] sections;

    public MetricBucket() {
        SectionEnum[] sectionValues = SectionEnum.values();
        sections = new LongAdder[sectionValues.length];
        for (int i = 0; i < sectionValues.length; i++) {
            sections[i] = new LongAdder();
        }
    }

    @Override
    public void reset() {
        for (SectionEnum field : SectionEnum.values()) {
            sections[field.ordinal()].reset();
        }
    }

    public void add(SectionEnum field, long count) {
        sections[field.ordinal()].add(count);
    }

    public void addPass(int count) {
        add(SectionEnum.PASS, count);
    }

    public void addBlock (int count) {
        add(SectionEnum.BLOCK, count);
    }

    public void addException (int count) {
        add(SectionEnum.EXCEPTION, count);
    }

    public void addSuccess(int count) {
        add(SectionEnum.SUCCESS, count);
    }

    public void addRt(long count) {
        add(SectionEnum.RT, count);
    }

    public long get(SectionEnum field) {
        return sections[field.ordinal()].sum();
    }

    public enum SectionEnum {
        PASS,
        BLOCK,
        EXCEPTION,
        SUCCESS,
        RT
    }
}
