package site.hellooo.sentry.node;

/**
 * @author Jeb.Wang
 * Time: 2023/2/7 15:58:26
 */
public class ResourceNode implements Node {

    private String resource;

    public ResourceNode() {

    }

    public ResourceNode(String resource) {
        this.resource = resource;
    }

    @Override
    public long passQps() {
        return 0;
    }

    @Override
    public long passQps(Object limitKey) {
        return 0;
    }

    @Override
    public long blockQps() {
        return 0;
    }

    @Override
    public long blockQps(Object limitKey) {
        return 0;
    }

    @Override
    public long exceptionQps() {
        return 0;
    }

    @Override
    public long exceptionQps(Object limitKey) {
        return 0;
    }

    @Override
    public long successQps() {
        return 0;
    }

    @Override
    public long successQps(Object limitKey) {
        return 0;
    }

    @Override
    public long totalQps() {
        return 0;
    }

    @Override
    public long totalQps(Object limitKey) {
        return 0;
    }

    @Override
    public void addException(Object limitKey, int count) {

    }

    @Override
    public void addBlock(Object limitKey, int count) {

    }

    @Override
    public void addPass(Object limitKey, int count) {

    }
}
