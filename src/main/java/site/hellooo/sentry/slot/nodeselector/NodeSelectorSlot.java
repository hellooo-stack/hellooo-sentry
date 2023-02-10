package site.hellooo.sentry.slot.nodeselector;

import site.hellooo.sentry.ResourceToken;
import site.hellooo.sentry.exception.BlockException;
import site.hellooo.sentry.node.Node;
import site.hellooo.sentry.node.ResourceNode;
import site.hellooo.sentry.slot.AbstractLinkedProcessorSlot;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jeb.Wang
 * Time: 2023/2/7 17:11:13
 */
public class NodeSelectorSlot extends AbstractLinkedProcessorSlot {

    private Map<String, Node> resourcesNodeMap = new HashMap<>();

    private Lock updateLock = new ReentrantLock();

    @Override
    public void entry(String resource, Node node, ResourceToken resourceToken, int token, Object limitKey) throws BlockException {
        if (node == null) {
            node = getNode(resource);
        }

        resourceToken.setNode(node);
        fireEntry(resource, node, resourceToken, token, limitKey);
    }

    @Override
    public void exit(String resource, Node node, ResourceToken resourceToken, int token) {
        fireExit(resource, node, resourceToken, token);
    }

    private Node getNode(String resource) {
        Node node = resourcesNodeMap.get(resource);
        if (node == null) {
            updateLock.lock();
            node = resourcesNodeMap.get(resource);
            if (node == null) {
                Map<String, Node> newMap = new HashMap<>(resourcesNodeMap.size());
                newMap.putAll(resourcesNodeMap);
                newMap.put(resource, node = new ResourceNode(resource));
                resourcesNodeMap = newMap;
            }
            updateLock.unlock();
        }

        return node;
    }
}