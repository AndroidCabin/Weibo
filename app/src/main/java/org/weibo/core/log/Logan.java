package org.weibo.core.log;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Log
 *
 * @author  Ivan J. Lee on 2019-05-03 13:24.
 * @version v0.1
 * @since   v1.0
 */
public class Logan {

    /**
     * Priority constant for the println method; use Log.v.
     */
    public static final int VERBOSE = 2;

    /**
     * Priority constant for the println method; use Log.d.
     */
    public static final int DEBUG = 3;

    /**
     * Priority constant for the println method; use Log.i.
     */
    public static final int INFO = 4;

    /**
     * Priority constant for the println method; use Log.w.
     */
    public static final int WARN = 5;

    /**
     * Priority constant for the println method; use Log.e.
     */
    public static final int ERROR = 6;

    /**
     * Priority constant for the println method.
     */
    public static final int ASSERT = 7;

    public static void v(String tag, String msg, Throwable throwable) {
        internalLog(VERBOSE, tag, msg, throwable);
    }

    public static void v(String tag, String msg) {
        v(tag, msg, null);
    }

    public static void v(String msg) {
        v(null, msg);
    }

    public static void d(String tag, String msg, Throwable throwable) {
        internalLog(DEBUG, tag, msg, throwable);
    }

    public static void d(String tag, String msg) {
        d(tag, msg, null);
    }

    public static void d(String msg) {
        d(null, msg);
    }

    public static void i(String tag, String msg, Throwable throwable) {
        internalLog(INFO, tag, msg, throwable);
    }

    public static void i(String tag, String msg) {
        i(tag, msg, null);
    }

    public static void i(String msg) {
        i(null, msg);
    }

    public static void w(String tag, String msg, Throwable throwable) {
        internalLog(WARN, tag, msg, throwable);
    }

    public static void w(String tag, String msg) {
        w(tag, msg, null);
    }

    public static void w(String msg) {
        w(null, msg);
    }

    public static void e(String tag, String msg, Throwable throwable) {
        internalLog(ERROR, tag, msg, throwable);
    }

    public static void e(String tag, String msg) {
        e(tag, msg, null);
    }

    public static void e(String msg) {
        e(null, msg);
    }

    public static void wtf(String tag, String msg, Throwable throwable) {
        internalLog(ASSERT, tag, msg, throwable);
    }

    public static void wtf(String tag, String msg) {
        wtf(tag, msg, null);
    }

    public static void wft(String msg) {
        wtf(null, msg);
    }

    private static class InstanceHolder {
        private static final Logan mLogan = new Logan();

        private static Logan getInstance() {
            return mLogan;
        }
    }

    private Set<ILogger> mLoggers = new LinkedHashSet<>(1);

    private String mDefaultTag = "Logan";

    private ExecutorService mExecutorService = Executors.newSingleThreadExecutor();

    public static Logan init() {
        return InstanceHolder.mLogan;
    }

    public Logan defauleTag(String tag) {
        mDefaultTag = tag;
        return this;
    }

    public Logan addLogger(ILogger logger) {
        mLoggers.add(logger);
        return this;
    }

    /**
     * print log internal
     *
     * @param level log level
     * @param tag log tag
     * @param msg log msg
     * @param throwable exception
     */
    private static void internalLog(int level, String tag, String msg, Throwable throwable) {
        Logan logan = InstanceHolder.getInstance();
        if (tag == null || "".equals(tag)) {
            tag = logan.mDefaultTag;
        }
        String finalTag = tag;
        logan.mExecutorService.submit(() -> {
            for (ILogger logger : logan.mLoggers) {
                logger.log(level, finalTag, msg, throwable);
            }
        });
    }
}
