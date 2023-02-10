package site.hellooo.sentry.slot;

import site.hellooo.sentry.ResourceToken;
import site.hellooo.sentry.exception.BlockException;
import site.hellooo.sentry.node.Node;

/**
 * @author Jeb.Wang
 * Time: 2023/2/7 16:04:22
 */
public abstract class AbstractLinkedProcessorSlot implements ProcessorSlot {
    private AbstractLinkedProcessorSlot next = null;

    @Override
    public void fireEntry(String resource, Node node, ResourceToken resourceToken, int token, Object limitKey) throws BlockException {
        if (next != null) {
            next.entry(resource, node, resourceToken, token, limitKey);
        }
    }

    @Override
    public void fireExit(String resource, Node node, ResourceToken resourceToken, int token) {
        if (next != null) {
            next.exit(resource, node, resourceToken, token);
        }
    }

    public AbstractLinkedProcessorSlot getNext() {
        return next;
    }

    public void setNext(AbstractLinkedProcessorSlot next) {
        this.next = next;
    }
}
