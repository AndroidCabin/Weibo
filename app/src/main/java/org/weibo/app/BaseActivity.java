package org.weibo.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.AnimRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

/**
 * BaseActivity
 *
 * @author Ivan
 */
public class BaseActivity extends AppCompatActivity {

    protected static final String TAG = BaseActivity.class.getName();

    protected void startActivity(Intent intent, @AnimRes int enterAnim, @AnimRes int exitAnim) {
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(this, enterAnim, exitAnim);
        ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onPreCreateView();
        setContentViewInternal();
        onPostCreateView();
    }

    protected void onPreCreateView() {}

    protected void onPostCreateView() {}

    private void setContentViewInternal() {
        int contentId = getContentView();
        if (contentId != View.NO_ID) {
            this.setContentView(contentId);
        }
    }

    protected @LayoutRes
    int getContentView() {
        return View.NO_ID;
    }

    protected void initToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    protected void initToolbar(@IdRes int id) {
        Toolbar toolbar = findViewById(id);
        initToolbar(toolbar);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                onBackPressed();
                break;
            case KeyEvent.KEYCODE_MENU:
                onMenuPressed();
                break;
            case KeyEvent.KEYCODE_HOME:
                onHomePressed();
                break;
            default:
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onMenuPressed() {}

    public void onHomePressed() {}
}
