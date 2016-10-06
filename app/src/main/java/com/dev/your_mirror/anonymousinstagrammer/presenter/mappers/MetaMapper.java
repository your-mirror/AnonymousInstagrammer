package com.dev.your_mirror.anonymousinstagrammer.presenter.mappers;

import com.dev.your_mirror.anonymousinstagrammer.model.dto.MetaDTO;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.Meta;

import rx.functions.Func1;


public class MetaMapper implements Func1<MetaDTO, Meta> {
    @Override
    public Meta call(MetaDTO metaDTO) {
        return new Meta(metaDTO.getCode());
    }
}
