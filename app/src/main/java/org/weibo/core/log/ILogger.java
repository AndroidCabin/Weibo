package org.weibo.core.log;

/**
 * log interface
 *
 * @author  Ivan J. Lee on 2019-05-05 22:54.
 * @version v0.1
 * @since   v1.0
 */
public interface ILogger {

    void log(int level, String tag, String msg, Throwable throwable);
}
