package com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects;


import java.util.List;

public class RecentMediaCommentsResponse {
    private Pagination pagination;
    private Meta meta;
    private List<Comment> commentList;

    public RecentMediaCommentsResponse(Pagination pagination, Meta meta, List<Comment> commentList) {
        this.pagination = pagination;
        this.meta = meta;
        this.commentList = commentList;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
