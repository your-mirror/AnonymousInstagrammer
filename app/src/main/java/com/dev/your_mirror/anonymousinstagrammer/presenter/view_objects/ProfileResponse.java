package com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects;


public class ProfileResponse {
    private Meta meta;
    private User user;

    public ProfileResponse(Meta meta, User user) {
        this.meta = meta;
        this.user = user;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
