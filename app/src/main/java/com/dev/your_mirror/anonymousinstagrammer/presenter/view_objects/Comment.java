package com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects;


public class Comment {
    private long createdTime;
    private String text;
    private User from;
    private long id;

    public Comment(long createdTime, String text, User from, long id) {
        this.createdTime = createdTime;
        this.text = text;
        this.from = from;
        this.id = id;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
