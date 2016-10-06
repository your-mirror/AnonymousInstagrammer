package com.dev.your_mirror.anonymousinstagrammer.presenter.mappers;

import com.dev.your_mirror.anonymousinstagrammer.model.dto.CommentDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.UserDTO;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.Comment;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.User;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;


public class CommentListMapper implements Func1<List<CommentDTO>, List<Comment>> {

    @Override
    public List<Comment> call(List<CommentDTO> commentDTOs) {
        List<Comment> comments = new ArrayList<Comment>(commentDTOs.size());
        for (CommentDTO commentDTO : commentDTOs) {
            UserDTO userDTO = commentDTO.getFrom();

            comments.add(new Comment(
                commentDTO.getCreatedTime(),
                commentDTO.getText(),
                new User(
                    userDTO.getUsername(), userDTO.getFullName(),
                    userDTO.getProfilePicture(), userDTO.getId()
                ),
                commentDTO.getId()
            ));
        }

        return comments;
    }
}