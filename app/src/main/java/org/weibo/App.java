package org.weibo;

import org.weibo.core.AppComponent;
import org.weibo.core.AppModule;
import org.weibo.core.DaggerAppComponent;

/**
 * module manager
 *
 * @author  Ivan J. Lee on 2019-05-03 13:10.
 * @version v0.1
 * @since   v1.0
 */
public class App {

    private volatile static App mApp;
    private static AppComponent mDaggerAppComponent;

    private App(WeiboApplication application) {
        mDaggerAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

    @SuppressWarnings("UnusedReturnValue")
    private static App get(WeiboApplication application) {
        if (mApp == null) {
            synchronized (App.class) {
                if (mApp == null) {
                    mApp = new App(application);
                }
            }
        }
        return mApp;
    }

    static void init(WeiboApplication application) {
        get(application);
    }

    public static AppComponent appComponent() {
        return mDaggerAppComponent;
    }
}
