package site.hellooo.sentry.slot.degrade;

import site.hellooo.sentry.ResourceToken;
import site.hellooo.sentry.exception.BlockException;
import site.hellooo.sentry.node.Node;
import site.hellooo.sentry.slot.AbstractLinkedProcessorSlot;

/**
 * @author Jeb.Wang
 * Time: 2023/2/7 17:07:17
 */
public class DegradeSlot extends AbstractLinkedProcessorSlot {
    @Override
    public void entry(String resource, Node node, ResourceToken resourceToken, int token, Object limitKey) throws BlockException {

    }

    @Override
    public void fireEntry(String resource, Node node, ResourceToken resourceToken, int token, Object limitKey) throws BlockException {

    }

    @Override
    public void exit(String resource, Node node, ResourceToken resourceToken, int token) {

    }

    @Override
    public void fireExit(String resource, Node node, ResourceToken resourceToken, int token) {

    }
}
