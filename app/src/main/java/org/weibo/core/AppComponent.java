package org.weibo.core;

import android.content.SharedPreferences;
import android.content.res.Resources;

import org.weibo.WeiboApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * AppComponent
 *
 * @author  Ivan J. Lee on 2019-05-03 12:59.
 * @version v0.1
 * @since   v1.0
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    WeiboApplication application();

    SharedPreferences preference();

    Resources resources();


}
