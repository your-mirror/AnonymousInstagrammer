package com.dev.your_mirror.anonymousinstagrammer.model;


import rx.Observable;

import com.dev.your_mirror.anonymousinstagrammer.model.dto.RecentMediaCommentsResponseDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.ProfileResponseDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.RecentMediaResponseDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.SearchUserResponseDTO;

public interface DTOProvider {

    Observable<SearchUserResponseDTO> searchUsers(String name, int count);

    Observable<ProfileResponseDTO> getProfile();

    Observable<RecentMediaResponseDTO> getRecentMedia(long userId, short count, String maxId);

    Observable<RecentMediaCommentsResponseDTO> getMediaComments(String mediaId, short count, String maxId);
}

