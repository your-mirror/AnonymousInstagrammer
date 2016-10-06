package com.dev.your_mirror.anonymousinstagrammer.presenter.mappers;

import com.dev.your_mirror.anonymousinstagrammer.model.dto.UserDTO;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.User;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;


public class UserListMapper implements Func1<List<UserDTO>, List<User>> {
    @Override
    public List<User> call(List<UserDTO> userDTOs) {
        List<User> users = new ArrayList<User>(userDTOs.size());
        for (UserDTO userDTO : userDTOs) {
            users.add(new User(
                userDTO.getUsername(), userDTO.getFullName(), userDTO.getProfilePicture(), userDTO.getId()
            ));
        }

        return users;
    }
}
