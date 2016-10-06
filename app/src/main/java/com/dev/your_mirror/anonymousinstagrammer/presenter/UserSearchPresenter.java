package com.dev.your_mirror.anonymousinstagrammer.presenter;


import android.content.res.Resources;

import com.dev.your_mirror.anonymousinstagrammer.R;
import com.dev.your_mirror.anonymousinstagrammer.presenter.mappers.SearchUserResponseMapper;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.Meta;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.SearchUserResponse;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.User;
import com.dev.your_mirror.anonymousinstagrammer.view.fragments.UserSearchFragment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observer;
import rx.Subscription;

public class UserSearchPresenter extends BasePresenter {
    public final int USER_PLACE_HOLDER_LIMIT = 20;

    private UserSearchFragment userSearchFragment;
    private Subscription userSearchResponseSubscription;
    private SearchUserResponseMapper searchUserResponseMapper;
    private Resources userSearchResources;

    public UserSearchPresenter(UserSearchFragment userSearchFragment) {
        this.userSearchFragment = userSearchFragment;
        this.searchUserResponseMapper = new SearchUserResponseMapper();
        this.userSearchResources = userSearchFragment.getResources();
    }

    @Override
    protected UserSearchFragment getPresenterView() {
        return userSearchFragment;
    }

    public void onEditSearchUser() {
        if (!getPresenterView().isNetworkConnected()) {
            getPresenterView().showError(
                userSearchResources.getString(R.string.error_title),
                userSearchResources.getString(R.string.network_connect_error_message)
            );
            return;
        }

        if (userSearchResponseSubscription != null && !userSearchResponseSubscription.isUnsubscribed()) {
            userSearchResponseSubscription.unsubscribe();
        }

        getPresenterView().updateSearchUserClearButton();

        String name = getPresenterView().getUserName();
        if (name.length() < 3) {
            getPresenterView().hideSearchUserProgressBar();
            getPresenterView().clearSearchUserAdapter();
            return;
        }

        getPresenterView().showSearchUserProgressBar();

        userSearchResponseSubscription = dtoProvider.searchUsers(name, USER_PLACE_HOLDER_LIMIT)
            .debounce(200, TimeUnit.MILLISECONDS)
            .map(searchUserResponseMapper)
            .subscribe(new Observer<SearchUserResponse>() {
                @Override
                public void onCompleted() {
                    userSearchFragment.hideSearchUserProgressBar();
                }

                @Override
                public void onError(Throwable e) {
                    getPresenterView().showError(
                        userSearchResources.getString(R.string.error_title),
                        e.getMessage()
                    );
                    getPresenterView().hideSearchUserProgressBar();
                }

                @Override
                public void onNext(SearchUserResponse searchUserResponse) {
                    int code = searchUserResponse.getMeta().getCode();
                    if (code != Meta.STATUS_OK) {
                        getPresenterView().showError(
                            userSearchResources.getString(R.string.error_title),
                            userSearchResources.getString(R.string.api_request_meta_error_message, code)
                        );
                    }

                    getPresenterView().updateSearchUserAdapter(searchUserResponse.getUsers());
                }
            });

        addSubscription(userSearchResponseSubscription);
    }

    public void onEmptySearchUser() {
        getPresenterView().clearSearchUserEditText();
    }

    public void onSearchUserItemClick(int position) {
        getPresenterView().goToUserMedia(position);
    }
}
