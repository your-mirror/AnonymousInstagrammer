package com.dev.your_mirror.anonymousinstagrammer.model.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import com.dev.your_mirror.anonymousinstagrammer.model.dto.RecentMediaCommentsResponseDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.ProfileResponseDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.RecentMediaResponseDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.SearchUserResponseDTO;
public interface ApiInterface {

    @GET("users/search")
    Observable<SearchUserResponseDTO> searchUsers(@Query("q") String searchName, @Query("count") int count);

    @GET("users/self")
    Observable<ProfileResponseDTO> getProfile();

    @GET("users/{user}/media/recent")
    Observable<RecentMediaResponseDTO> getRecentMedia(
        @Path("user") long userId, @Query("count") short count, @Query("max_id") String maxId
    );

    @GET("media/{media_id}/comments")
    Observable<RecentMediaCommentsResponseDTO> getMediaComments(
        @Path("media_id") String mediaId, @Query("count") short count, @Query("max_id") String maxId
    );
}