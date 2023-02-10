package site.hellooo.sentry.rule;

import site.hellooo.commons.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jeb.Wang
 * Time: 2023/2/7 17:39:17
 */
public class FlowRuleManager {
    private static Map<String, List<FlowRule>> resourceRulesMap = new HashMap<>();

    public static void loadRule(FlowRule rule) {
        String resource = rule.getResource();
        if (StringUtils.isEmpty(resource)) {
            throw new NullPointerException();
        }

        List<FlowRule> rules = resourceRulesMap.get(resource);
        if (rules == null) {
            resourceRulesMap.put(resource, rules = new ArrayList<>());
        }
//        todo?
    }

    public static List<FlowRule> getRules(String resource) {
        return resourceRulesMap.get(resource);
    }

}
