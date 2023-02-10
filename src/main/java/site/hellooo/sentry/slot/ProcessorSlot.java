package site.hellooo.sentry.slot;

import site.hellooo.sentry.ResourceToken;
import site.hellooo.sentry.exception.BlockException;
import site.hellooo.sentry.node.Node;

/**
 * @author Jeb.Wang
 */
public interface ProcessorSlot {
    void entry(String resource, Node node, ResourceToken resourceToken, int token, Object limitKey) throws BlockException;

    void fireEntry(String resource, Node node, ResourceToken resourceToken, int token, Object limitKey) throws BlockException;

    void exit(String resource, Node node, ResourceToken resourceToken, int token);

    void fireExit(String resource, Node node, ResourceToken resourceToken, int token);
}
