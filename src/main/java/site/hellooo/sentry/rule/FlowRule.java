package site.hellooo.sentry.rule;

/**
 * @author Jeb.Wang
 * Time: 2023/2/7 17:28:12
 */
public class FlowRule extends Rule {

    private long threshold;

    private ControlBehavior controlBehavior = ControlBehavior.Reject;

}
