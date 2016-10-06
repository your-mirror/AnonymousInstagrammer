package com.dev.your_mirror.anonymousinstagrammer.presenter;


import android.content.res.Resources;

import com.dev.your_mirror.anonymousinstagrammer.R;
import com.dev.your_mirror.anonymousinstagrammer.presenter.mappers.RecentMediaResponseMapper;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.Pagination;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.RecentMediaResponse;
import com.dev.your_mirror.anonymousinstagrammer.view.fragments.UserMediaListFragment;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;


public class UserMediaListPresenter extends BasePresenter {
    public final short MEDIAS_PER_REQUEST = 10;

    private UserMediaListFragment userMediaListFragment;
    private boolean isAllLoaded = false;
    private long userId;
    private String nextMaxId = "";
    private Subscription recentMediaResponseSubscription;
    private RecentMediaResponseMapper recentMediaResponseMapper = new RecentMediaResponseMapper();


    public UserMediaListPresenter(UserMediaListFragment userMediaListFragment, long userId) {
        this.userMediaListFragment = userMediaListFragment;
        this.userId = userId;
    }

    @Override
    protected UserMediaListFragment getPresenterView() {
        return userMediaListFragment;
    }

    public void onScrollUserMediaGridView() {
        if (recentMediaResponseSubscription != null || isAllLoaded) {
            return;
        }

        getPresenterView().showRecentMediaProgressBar();

        recentMediaResponseSubscription = dtoProvider.getRecentMedia(userId, MEDIAS_PER_REQUEST, nextMaxId)
            .timeout(15, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
            .map(recentMediaResponseMapper)
            .subscribe(new Observer<RecentMediaResponse>() {
                @Override
                public void onCompleted() {
                    recentMediaResponseSubscription = null;
                    getPresenterView().hideRecentMediaProgressBar();
                }

                @Override
                public void onError(Throwable e) {
                    recentMediaResponseSubscription = null;
                    Resources resources = getPresenterView().getResources();
                    String message = e instanceof TimeoutException
                        ? resources.getString(R.string.network_connect_error_message)
                        : e.getMessage();

                    getPresenterView().hideRecentMediaProgressBar();
                    getPresenterView().showError(
                        getPresenterView().getResources().getString(R.string.error_title),
                        message
                    );
                }

                @Override
                public void onNext(RecentMediaResponse recentMediaResponse) {
                    if (recentMediaResponse == null) {
                        return;
                    }

                    Pagination pagination = recentMediaResponse.getPagination();
                    String responseNextMaxId = pagination != null ? pagination.getNextMaxId() : null;
                    if (responseNextMaxId == null) {
                        isAllLoaded = true;
                    }
                    else {
                        nextMaxId = responseNextMaxId;
                    }

                    getPresenterView().updateRecentMediaAdapter(recentMediaResponse.getRecentMedias());
                }
            });

        addSubscription(recentMediaResponseSubscription);
    }
}
