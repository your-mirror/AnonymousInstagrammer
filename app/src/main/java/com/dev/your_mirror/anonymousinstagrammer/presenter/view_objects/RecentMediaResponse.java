package com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects;


import java.util.List;

public class RecentMediaResponse {
    private Pagination pagination;
    private Meta meta;
    private List<RecentMedia> recentMedias;

    public RecentMediaResponse(Pagination pagination, Meta meta, List<RecentMedia> recentMedias) {
        this.pagination = pagination;
        this.meta = meta;
        this.recentMedias = recentMedias;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<RecentMedia> getRecentMedias() {
        return recentMedias;
    }

    public void setRecentMedias(List<RecentMedia> recentMedias) {
        this.recentMedias = recentMedias;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
