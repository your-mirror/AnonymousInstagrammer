package com.dev.your_mirror.anonymousinstagrammer.model.dto;


import java.util.List;

public class RecentMediaCommentsResponseDTO {
    private PaginationDTO pagination;
    private MetaDTO meta;
    private List<CommentDTO> data;

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

    public List<CommentDTO> getData() {
        return data;
    }

    public void setData(List<CommentDTO> data) {
        this.data = data;
    }
}
