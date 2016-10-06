package com.dev.your_mirror.anonymousinstagrammer.presenter.mappers;

import com.dev.your_mirror.anonymousinstagrammer.model.dto.MetaDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.PaginationDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.RecentMediaDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.RecentMediaResponseDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.ResolutionDTO;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.Meta;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.RecentMedia;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.RecentMediaResponse;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.Resolution;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rx.functions.Func1;


public class RecentMediaResponseMapper implements Func1<RecentMediaResponseDTO, RecentMediaResponse> {
    PaginationMapper paginationMapper = new PaginationMapper();
    MetaMapper metaMapper = new MetaMapper();
    UserMapper userMapper = new UserMapper();
    MediaTypeMapper mediaTypeMapper = new MediaTypeMapper();
    ResolutionMapper resolutionMapper = new ResolutionMapper();

    @Override
    public RecentMediaResponse call(RecentMediaResponseDTO recentMediaResponseDTO) {
        List<RecentMediaDTO> recentMediaDTOs = recentMediaResponseDTO.getData();
        List<RecentMedia> recentMedias = new ArrayList<RecentMedia>(recentMediaDTOs.size());
        for (RecentMediaDTO recentMediaDTO : recentMediaDTOs) {
            RecentMedia.Type type = mediaTypeMapper.call(recentMediaDTO.getType());
            Map<Resolution.TYPE, Resolution> imageMap = resolutionMapper.call(recentMediaDTO.getImages());
            Map<Resolution.TYPE, Resolution> videoMap =  null;

            if (type == RecentMedia.Type.VIDEO) {
                resolutionMapper.call(recentMediaDTO.getVideos());
            }

            recentMedias.add(new RecentMedia(
                recentMediaDTO.getId(), recentMediaDTO.getCreatedTime(), type,
                userMapper.call(recentMediaDTO.getUser()), imageMap, videoMap
            ));
        }

        return new RecentMediaResponse(
                paginationMapper.call(recentMediaResponseDTO.getPagination()),
                metaMapper.call(recentMediaResponseDTO.getMeta()),
                recentMedias
        );
    }
}
