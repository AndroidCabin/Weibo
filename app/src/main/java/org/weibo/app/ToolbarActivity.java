package org.weibo.app;

import android.annotation.SuppressLint;

import androidx.appcompat.widget.Toolbar;

import org.weibo.R;

/**
 * Activity with a default toolbar
 *
 * @author  Ivan on 2018-12-23 14:09.
 * @version v0.1
 * @since   v1.0
 */
@SuppressLint("Registered")
public class ToolbarActivity extends BaseActivity {

    protected Toolbar toolbar;

    @Override
    protected void onPostCreateView() {
        super.onPostCreateView();
        setUpToolbar();
    }

    protected void setUpToolbar() {
        toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            initToolbar(toolbar);
        }
    }
}
