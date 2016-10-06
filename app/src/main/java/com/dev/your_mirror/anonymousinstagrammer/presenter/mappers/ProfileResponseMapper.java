package com.dev.your_mirror.anonymousinstagrammer.presenter.mappers;

import com.dev.your_mirror.anonymousinstagrammer.model.dto.MetaDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.ProfileResponseDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.UserDTO;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.Meta;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.ProfileResponse;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.User;

import rx.Observable;
import rx.functions.Func1;


public class ProfileResponseMapper implements Func1<ProfileResponseDTO, ProfileResponse> {
    @Override
    public ProfileResponse call(ProfileResponseDTO profileResponseDTO) {
        MetaDTO metaDTO = profileResponseDTO.getMeta();
        UserDTO userDTO = profileResponseDTO.getData();

        return new ProfileResponse(
            new Meta(metaDTO.getCode()),
            new User(userDTO.getUsername(), userDTO.getFullName(),
                userDTO.getProfilePicture(), userDTO.getId()
            )
        );
    }
}
