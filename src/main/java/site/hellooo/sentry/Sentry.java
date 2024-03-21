package site.hellooo.sentry;

import site.hellooo.sentry.exception.RateLimitException;

/**
 * Author: Jeb.Wang
 * Time: 2023/1/7 23:05:06
 */
public interface Sentry {
    void guard() throws RateLimitException;
}
