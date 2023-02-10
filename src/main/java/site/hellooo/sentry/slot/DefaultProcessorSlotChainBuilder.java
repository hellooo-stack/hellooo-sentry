package site.hellooo.sentry.slot;

import site.hellooo.sentry.slot.degrade.DegradeSlot;
import site.hellooo.sentry.slot.flow.FlowSlot;
import site.hellooo.sentry.slot.limitkey.LimitKeySlot;
import site.hellooo.sentry.slot.nodeselector.NodeSelectorSlot;
import site.hellooo.sentry.slot.statistic.StatisticSlot;

/**
 * @author Jeb.Wang
 * Time: 2023/2/7 17:05:40
 */
public class DefaultProcessorSlotChainBuilder implements ProcessorSlotChainBuilder {
    @Override
    public ProcessorSlotChain build() {
        ProcessorSlotChain chain = new DefaultProcessorSlotChain();
        chain.addLast(new NodeSelectorSlot());
        chain.addLast(new StatisticSlot());
        chain.addLast(new LimitKeySlot());
        chain.addLast(new FlowSlot());
        chain.addLast(new DegradeSlot());

        return chain;
    }
}
