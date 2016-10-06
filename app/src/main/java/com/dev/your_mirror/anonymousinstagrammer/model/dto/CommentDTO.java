package com.dev.your_mirror.anonymousinstagrammer.model.dto;


public class CommentDTO {

    private long createdTime;
    private String text;
    private UserDTO from;
    private long id;

    /**
     *
     * @return
     * The createdTime
     */
    public long getCreatedTime() {
        return createdTime;
    }

    /**
     *
     * @param createdTime
     * The created_time
     */
    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    /**
     *
     * @return
     * The text
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     * The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     * The from
     */
    public UserDTO getFrom() {
        return from;
    }

    /**
     *
     * @param from
     * The from
     */
    public void setFrom(UserDTO from) {
        this.from = from;
    }

    /**
     *
     * @return
     * The id
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(long id) {
        this.id = id;
    }

}