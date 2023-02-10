package site.hellooo.sentry.slot.statistic;

import site.hellooo.sentry.ResourceToken;
import site.hellooo.sentry.exception.BlockException;
import site.hellooo.sentry.node.Node;

/**
 * @author Jeb.Wang
 * Time: 2023/2/7 19:36:47
 */
public class LimitKeyStatisticCallback implements StatisticCallback {
    @Override
    public void afterPass(String resource, Node node, ResourceToken resourceToken, int token, Object limitKey) {

    }

    @Override
    public void afterBlocked(BlockException exp, String resource, Node node, ResourceToken resourceToken, int token, Object limitKey) {

    }
}
