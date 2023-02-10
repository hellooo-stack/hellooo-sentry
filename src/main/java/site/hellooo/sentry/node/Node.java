package site.hellooo.sentry.node;

/**
 * @author Jeb.Wang
 * Time: 2023/2/7 15:45:27
 */
public interface Node {
    long passQps();

    long passQps(Object limitKey);

    long blockQps();

    long blockQps(Object limitKey);

    long exceptionQps();

    long exceptionQps(Object limitKey);

    long successQps();

    long successQps(Object limitKey);

    long totalQps();

    long totalQps(Object limitKey);

    void addException(Object limitKey, int count);

    void addBlock(Object limitKey, int count);

    void addPass(Object limitKey, int count);


}
