package com.dev.your_mirror.anonymousinstagrammer.model.dto;


import java.util.List;

public class RecentMediaResponseDTO {
    private PaginationDTO pagination;
    private MetaDTO meta;
    private List<RecentMediaDTO> data;

    public PaginationDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationDTO pagination) {
        this.pagination = pagination;
    }

    public MetaDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaDTO meta) {
        this.meta = meta;
    }

    public List<RecentMediaDTO> getData() {
        return data;
    }

    public void setData(List<RecentMediaDTO> data) {
        this.data = data;
    }
}
