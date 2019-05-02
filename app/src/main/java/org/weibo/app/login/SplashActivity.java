package org.weibo.app.login;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import org.weibo.R;
import org.weibo.app.BaseActivity;
import org.weibo.app.main.MainActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().getDecorView().setFitsSystemWindows(true);
        Handler handler = new Handler(getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                navigation();
            }
        };

        handler.sendEmptyMessageDelayed(0, 3000);
    }

    private void navigation() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class), R.anim.alpha_in, R.anim.alpha_out);
        SplashActivity.this.finish();
    }
}
