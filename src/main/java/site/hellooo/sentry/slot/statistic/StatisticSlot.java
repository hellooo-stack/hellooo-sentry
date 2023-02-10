package site.hellooo.sentry.slot.statistic;

import site.hellooo.sentry.ResourceToken;
import site.hellooo.sentry.exception.BlockException;
import site.hellooo.sentry.node.Node;
import site.hellooo.sentry.slot.AbstractLinkedProcessorSlot;

/**
 * @author Jeb.Wang
 * Time: 2023/2/7 17:11:24
 */
public class StatisticSlot extends AbstractLinkedProcessorSlot {
    @Override
    public void entry(String resource, Node node, ResourceToken resourceToken, int token, Object limitKey) throws BlockException {
        try {
            fireEntry(resource, node, resourceToken, token, limitKey);
            node.addPass(limitKey, token);

            for (StatisticCallback statisticCallback : StatisticSlotCallbackRegistry.getAllCallback()) {
                statisticCallback.afterPass(resource, node, resourceToken, token, limitKey);
            }
        } catch (BlockException e) {
            node.addBlock(limitKey, token);

            for (StatisticCallback statisticCallback : StatisticSlotCallbackRegistry.getAllCallback()) {
                statisticCallback.afterBlocked(e, resource, node, resourceToken, token, limitKey);
            }

            throw e;
        }
    }

    @Override
    public void exit(String resource, Node node, ResourceToken resourceToken, int token) {

    }
}