package com.dev.your_mirror.anonymousinstagrammer.model.dto;


public class ProfileResponseDTO {
    private MetaDTO meta;
    private UserDTO data;

    public MetaDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaDTO meta) {
        this.meta = meta;
    }

    public UserDTO getData() {
        return data;
    }

    public void setData(UserDTO data) {
        this.data = data;
    }
}
