package com.dev.your_mirror.anonymousinstagrammer.presenter.mappers;

import com.dev.your_mirror.anonymousinstagrammer.model.dto.UserDTO;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.User;

import rx.Observable;
import rx.functions.Func1;



public class UserMapper implements Func1<UserDTO, User> {
    @Override
    public User call(UserDTO userDTO) {
        return new User(
            userDTO.getUsername(), userDTO.getFullName(), userDTO.getProfilePicture(), userDTO.getId()
        );
    }
}
