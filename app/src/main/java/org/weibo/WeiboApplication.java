package org.weibo;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;

import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;

/**
 * Base Application
 *
 * @author  Iavn J. Lee on 2019-05-03 12:42.
 * @version v0.1
 * @since   v1.0
 */
public class WeiboApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        App.init(this);
        initWeiboSdk();
    }

    private void initWeiboSdk() {
        ApplicationInfo applicationInfo = getApplicationInfo();
        Bundle bundle = applicationInfo.metaData;
        WbSdk.install(this, AuthInfo.parseBundleData(this, bundle));
    }
}
