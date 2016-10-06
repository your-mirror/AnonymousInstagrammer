package com.dev.your_mirror.anonymousinstagrammer.presenter;

import android.content.Context;
import android.net.ConnectivityManager;

import com.dev.your_mirror.anonymousinstagrammer.model.DTOProvider;
import com.dev.your_mirror.anonymousinstagrammer.model.DTOProviderImpl;
import com.dev.your_mirror.anonymousinstagrammer.view.PresenterView;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter {

    protected DTOProvider dtoProvider = new DTOProviderImpl();
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    protected void addSubscription(Subscription subscription) {
        compositeSubscription.add(subscription);
    }

    public void onStop() {
        compositeSubscription.clear();
    }

    abstract PresenterView getPresenterView();
}
