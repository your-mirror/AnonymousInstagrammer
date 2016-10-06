package com.dev.your_mirror.anonymousinstagrammer.presenter.mappers;

import com.dev.your_mirror.anonymousinstagrammer.model.dto.MetaDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.SearchUserResponseDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.UserDTO;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.Meta;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.SearchUserResponse;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.User;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Func1;


public class SearchUserResponseMapper implements Func1<SearchUserResponseDTO, SearchUserResponse> {
    @Override
    public SearchUserResponse call(SearchUserResponseDTO searchUserResponseDTO) {
        MetaDTO metaDTO = searchUserResponseDTO.getMeta();
        List<UserDTO> userDTOs = searchUserResponseDTO.getData();

        List<User> users = new ArrayList<User>(userDTOs.size());
        for (UserDTO userDTO : userDTOs) {
            users.add(new User(
                userDTO.getUsername(), userDTO.getFullName(), userDTO.getProfilePicture(), userDTO.getId()
            ));
        }

        return new SearchUserResponse(new Meta(metaDTO.getCode()), users);
    }
}
