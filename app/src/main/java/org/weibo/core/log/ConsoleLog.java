package org.weibo.core.log;

import android.util.Log;

import org.weibo.BuildConfig;

/**
 * log write to console
 *
 * @author  Ivan J. Lee on 2019-05-05 23:22.
 * @version v0.1
 * @since   v1.0
 */
public class ConsoleLog implements ILogger {

    @Override
    public void log(int level, String tag, String msg, Throwable throwable) {
        if (!BuildConfig.DEBUG) {
            return;
        }
        switch (level) {
            case Logan.VERBOSE:
                Log.v(tag, msg, throwable);
                break;
            case Logan.DEBUG:
                Log.d(tag, msg, throwable);
                break;
            case Logan.INFO:
                Log.i(tag, msg, throwable);
            case Logan.WARN:
                Log.w(tag, msg, throwable);
            case Logan.ERROR:
                Log.e(tag, msg, throwable);
            case Logan.ASSERT:
                Log.wtf(tag, msg, throwable);
            default:
                Log.v(tag, msg, throwable);

        }
    }
}
