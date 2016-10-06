package com.dev.your_mirror.anonymousinstagrammer.presenter;


import android.content.res.Resources;

import com.dev.your_mirror.anonymousinstagrammer.R;
import com.dev.your_mirror.anonymousinstagrammer.presenter.mappers.RecentMediaCommentsResponseMapper;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.Pagination;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.RecentMedia;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.RecentMediaCommentsResponse;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.Resolution;
import com.dev.your_mirror.anonymousinstagrammer.view.fragments.UserMediaFragment;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class UserMediaPresenter extends BasePresenter {
    public final short COMMENTS_PER_REQUEST = 10;

    private UserMediaFragment userMediaFragment;
    private RecentMedia recentMedia;
    private Subscription commentsResponseSubscription;
    private RecentMediaCommentsResponseMapper commentsResponseMapper = new RecentMediaCommentsResponseMapper();
    private String nextMaxId = "";
    private boolean isAllLoaded = false;

    public UserMediaPresenter(UserMediaFragment userMediaFragment, RecentMedia recentMedia) {
        this.userMediaFragment = userMediaFragment;
        this.recentMedia = recentMedia;

        onInit();
    }

    protected void onInit() {
        userMediaFragment.setPostImage(recentMedia.getImages().get(Resolution.TYPE.STANDARD).getUrl());
    }

    @Override
    protected UserMediaFragment getPresenterView() {
        return userMediaFragment;
    }

    public void onScrollCommentsView() {
        if (commentsResponseSubscription != null || isAllLoaded) {
            return;
        }

        getPresenterView().showRecentMediaProgressBar();

        commentsResponseSubscription = dtoProvider.getMediaComments(recentMedia.getId(), COMMENTS_PER_REQUEST, nextMaxId)
            .timeout(15, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
            .map(commentsResponseMapper)
            .subscribe(new Observer<RecentMediaCommentsResponse>() {
                @Override
                public void onCompleted() {
                    commentsResponseSubscription = null;
                    getPresenterView().hideRecentMediaProgressBar();
                }

                @Override
                public void onError(Throwable e) {
                    commentsResponseSubscription = null;
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
                public void onNext(RecentMediaCommentsResponse commentsResponse) {
                    if (commentsResponse == null) {
                        return;
                    }

                    Pagination pagination = commentsResponse.getPagination();
                    String responseNextMaxId = pagination != null ? pagination.getNextMaxId() : null;
                    if (responseNextMaxId == null) {
                        isAllLoaded = true;
                    }
                    else {
                        nextMaxId = responseNextMaxId;
                    }

                    getPresenterView().updateRecentMediaAdapter(commentsResponse.getCommentList());
                }
            });

        addSubscription(commentsResponseSubscription);
    }
}
