package com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects;

public class Pagination {

    private String nextUrl;
    private String nextMaxId;

    public Pagination(String nextUrl, String nextMaxId) {
        this.nextUrl = nextUrl;
        this.nextMaxId = nextMaxId;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public String getNextMaxId() {
        return nextMaxId;
    }

    public void setNextMaxId(String nextMaxId) {
        this.nextMaxId = nextMaxId;
    }
}
