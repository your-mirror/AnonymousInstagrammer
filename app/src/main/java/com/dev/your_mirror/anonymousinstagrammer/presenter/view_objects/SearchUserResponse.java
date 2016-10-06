package com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects;


import java.util.List;

public class SearchUserResponse {
    private Meta meta;
    private List<User> users;

    public SearchUserResponse(Meta meta, List<User> users) {
        this.meta = meta;
        this.users = users;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
