package site.hellooo.sentry;

import site.hellooo.sentry.node.Node;
import site.hellooo.sentry.slot.ProcessorSlotChain;

/**
 * @author Jeb.Wang
 * Time: 2023/2/7 16:22:14
 */
public class ResourceToken {
    private String resource;
    private Node node;
    private Object limitKey;
    private ProcessorSlotChain chain;

    public ResourceToken() {

    }

    public ResourceToken(String resource, Node node, Object limitKey, ProcessorSlotChain chain) {
        this.resource = resource;
        this.node = node;
        this.limitKey = limitKey;
        this.chain = chain;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Object getLimitKey() {
        return limitKey;
    }

    public void setLimitKey(Object limitKey) {
        this.limitKey = limitKey;
    }

    public ProcessorSlotChain getChain() {
        return chain;
    }

    public void setChain(ProcessorSlotChain chain) {
        this.chain = chain;
    }
}
