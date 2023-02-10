package site.hellooo.sentry.slot;

/**
 * @author Jeb.Wang
 * Time: 2023/2/7 16:41:04
 */
public abstract class ProcessorSlotChain extends AbstractLinkedProcessorSlot {
    public abstract ProcessorSlotChain addFirst(AbstractLinkedProcessorSlot processorSlot);

    public abstract ProcessorSlotChain addLast(AbstractLinkedProcessorSlot processorSlot);
}
