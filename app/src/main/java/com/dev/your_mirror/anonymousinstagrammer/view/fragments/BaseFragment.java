package com.dev.your_mirror.anonymousinstagrammer.view.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v4.app.Fragment;

import com.dev.your_mirror.anonymousinstagrammer.presenter.BasePresenter;
import com.dev.your_mirror.anonymousinstagrammer.view.PresenterView;

public abstract class BaseFragment extends Fragment implements PresenterView {

    public abstract BasePresenter getPresenter();

    @Override
    public void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }

    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
