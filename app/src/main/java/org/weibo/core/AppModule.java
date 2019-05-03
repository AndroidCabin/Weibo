package org.weibo.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import org.weibo.WeiboApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * App Module to hold application
 *
 * @author  Ivan J. Lee on 2019-05-03 12:58.
 * @version v0.1
 * @since   v1.0
 */
@Module
public class AppModule {

    private WeiboApplication mApplication;

    public AppModule(WeiboApplication application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    WeiboApplication provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    SharedPreferences providePreference() {
        return mApplication.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return mApplication.getResources();
    }
}
