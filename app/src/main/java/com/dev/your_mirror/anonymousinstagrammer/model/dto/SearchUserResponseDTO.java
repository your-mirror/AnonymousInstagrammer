package com.dev.your_mirror.anonymousinstagrammer.model.dto;


import java.util.List;

public class SearchUserResponseDTO {

    private MetaDTO meta;
    private List<UserDTO> data;

    public MetaDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaDTO meta) {
        this.meta = meta;
    }

    public List<UserDTO> getData() {
        return data;
    }

    public void setData(List<UserDTO> data) {
        this.data = data;
    }
}
