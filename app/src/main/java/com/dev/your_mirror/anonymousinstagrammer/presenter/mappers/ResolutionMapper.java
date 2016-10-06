package com.dev.your_mirror.anonymousinstagrammer.presenter.mappers;


import com.dev.your_mirror.anonymousinstagrammer.model.dto.ResolutionDTO;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.Resolution;

import java.util.HashMap;
import java.util.Map;

import rx.functions.Func1;


public class ResolutionMapper implements Func1<Map<String, ResolutionDTO>, Map<Resolution.TYPE, Resolution>> {
    @Override
    public Map<Resolution.TYPE, Resolution> call(Map<String, ResolutionDTO> resolutionDTOMap) {
        Resolution.TYPE type;
        Map<Resolution.TYPE, Resolution> resolutionMap = new HashMap<Resolution.TYPE, Resolution>();
        for(Map.Entry<String, ResolutionDTO> entry : resolutionDTOMap.entrySet()) {
            ResolutionDTO resolutionDTO = entry.getValue();

            switch (entry.getKey()) {
                case "low_resolution":
                    type = Resolution.TYPE.LOW_RESOLUTION;
                    break;
                case "standard_resolution":
                    type = Resolution.TYPE.STANDARD;
                    break;
                default:
                    type = Resolution.TYPE.THUMBNAIL;
            }
            resolutionMap.put(
                type, new Resolution(resolutionDTO.getUrl(), resolutionDTO.getWidth(), resolutionDTO.getHeight())
            );
        }

        return resolutionMap;
    }
}
