package site.hellooo.sentry.slot.statistic;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jeb.Wang
 * Time: 2023/2/7 19:27:47
 */
public class StatisticSlotCallbackRegistry {
    private static Map<String, StatisticCallback> callbackMaps = new ConcurrentHashMap<>();

    public static void addCallback(String name, StatisticCallback callback) {
        callbackMaps.put(name, callback);
    }

    public static Collection<StatisticCallback> getAllCallback() {
        return callbackMaps.values();
    }
}
