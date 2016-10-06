package com.dev.your_mirror.anonymousinstagrammer.presenter.mappers;


import com.dev.your_mirror.anonymousinstagrammer.model.dto.RecentMediaCommentsResponseDTO;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.RecentMediaCommentsResponse;

import rx.functions.Func1;


public class RecentMediaCommentsResponseMapper implements Func1<RecentMediaCommentsResponseDTO, RecentMediaCommentsResponse> {
    PaginationMapper paginationMapper = new PaginationMapper();
    MetaMapper metaMapper = new MetaMapper();
    CommentListMapper commentListMapper = new CommentListMapper();

    @Override
    public RecentMediaCommentsResponse call(RecentMediaCommentsResponseDTO commentsResponseDTO) {
        return new RecentMediaCommentsResponse(
            paginationMapper.call(commentsResponseDTO.getPagination()),
            metaMapper.call(commentsResponseDTO.getMeta()),
            commentListMapper.call(commentsResponseDTO.getData())
        );
    }
}
