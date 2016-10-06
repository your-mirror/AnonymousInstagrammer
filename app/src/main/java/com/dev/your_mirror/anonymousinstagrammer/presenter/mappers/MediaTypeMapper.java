package com.dev.your_mirror.anonymousinstagrammer.presenter.mappers;

import com.dev.your_mirror.anonymousinstagrammer.model.dto.RecentMediaDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.UserDTO;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.RecentMedia;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.User;

import rx.functions.Func1;


public class MediaTypeMapper implements Func1<String, RecentMedia.Type> {

    @Override
    public RecentMedia.Type call(String typeDTO) {
        RecentMedia.Type type;

        switch (typeDTO) {
            case "video":
                type = RecentMedia.Type.VIDEO;
                break;
            default:
                type = RecentMedia.Type.IMAGE;
        }
        return type;
    }
}
