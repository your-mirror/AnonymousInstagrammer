package com.dev.your_mirror.anonymousinstagrammer.model;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import com.dev.your_mirror.anonymousinstagrammer.model.api.ApiInterface;
import com.dev.your_mirror.anonymousinstagrammer.model.api.ApiModule;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.RecentMediaCommentsResponseDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.ProfileResponseDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.RecentMediaResponseDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.SearchUserResponseDTO;

public class DTOProviderImpl implements DTOProvider {
    ApiInterface apiInterface = ApiModule.getApiInterface();

    @Override
    public Observable<SearchUserResponseDTO> searchUsers(String name, int count) {
        return apiInterface.searchUsers(name, count)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ProfileResponseDTO> getProfile() {
        return apiInterface.getProfile()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<RecentMediaResponseDTO> getRecentMedia(long userId, short count, String maxId) {
        return apiInterface.getRecentMedia(userId, count, maxId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<RecentMediaCommentsResponseDTO> getMediaComments(String mediaId, short count, String maxId) {
        return apiInterface.getMediaComments(mediaId, count, maxId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }
}
