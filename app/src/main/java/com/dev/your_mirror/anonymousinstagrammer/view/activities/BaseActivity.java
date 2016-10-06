package com.dev.your_mirror.anonymousinstagrammer.view.activities;


import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;

import com.dev.your_mirror.anonymousinstagrammer.presenter.BasePresenter;
import com.dev.your_mirror.anonymousinstagrammer.view.PresenterView;

public abstract class BaseActivity extends AppCompatActivity implements PresenterView {
    public abstract BasePresenter getPresenter();

    @Override
    protected void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }

    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
