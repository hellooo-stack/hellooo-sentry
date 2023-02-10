package site.hellooo.sentry.slot;

import site.hellooo.sentry.ResourceToken;
import site.hellooo.sentry.exception.BlockException;
import site.hellooo.sentry.node.Node;

/**
 * @author Jeb.Wang
 * Time: 2023/2/7 16:46:53
 */
public class DefaultProcessorSlotChain extends ProcessorSlotChain {

    private AbstractLinkedProcessorSlot first = new AbstractLinkedProcessorSlot() {
        @Override
        public void entry(String resource, Node node, ResourceToken resourceToken, int token, Object limitKey) throws BlockException {
            fireEntry(resource, node, resourceToken, token, limitKey);
        }

        @Override
        public void exit(String resource, Node node, ResourceToken resourceToken, int token) {
            fireExit(resource, node, resourceToken, token);
        }
    };

    private AbstractLinkedProcessorSlot last = first;

    @Override
    public void entry(String resource, Node node, ResourceToken resourceToken, int token, Object limitKey) throws BlockException {
        first.entry(resource, node, resourceToken, token, limitKey);
    }

    @Override
    public void exit(String resource, Node node, ResourceToken resourceToken, int token) {
        first.fireExit(resource, node, resourceToken, token);
    }

    @Override
    public ProcessorSlotChain addFirst(AbstractLinkedProcessorSlot processorSlot) {
        processorSlot.setNext(first.getNext());
        first.setNext(processorSlot);
        if (last == first) {
            last = processorSlot;
        }
        return this;
    }

    @Override
    public ProcessorSlotChain addLast(AbstractLinkedProcessorSlot processorSlot) {
        last.setNext(processorSlot);
        last = processorSlot;
        return this;
    }
}
