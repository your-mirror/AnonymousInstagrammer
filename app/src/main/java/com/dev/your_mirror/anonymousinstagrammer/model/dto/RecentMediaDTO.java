package com.dev.your_mirror.anonymousinstagrammer.model.dto;


import java.util.Map;

import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecentMediaDTO {
    @SerializedName("comments")
    @Expose
    private CommentsDTO comments;
    @SerializedName("user")
    @Expose
    private UserDTO user;
    @SerializedName("created_time")
    @Expose
    private long createdTime;
    @SerializedName("images")
    @Expose
    private Map<String, ResolutionDTO> images;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("videos")
    @Expose
    private Map<String, ResolutionDTO> videos;

    /**
     * 
     * @return
     *     The comments
     */
    public CommentsDTO getComments() {
        return comments;
    }

    /**
     * 
     * @param comments
     *     The comments
     */
    public void setComments(CommentsDTO comments) {
        this.comments = comments;
    }

    /**
     * 
     * @return
     *     The user
     */
    public UserDTO getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User UserDTO) {
        this.user = user;
    }

    /**
     * 
     * @return
     *     The createdTime
     */
    public long getCreatedTime() {
        return createdTime;
    }

    /**
     * 
     * @param createdTime
     *     The created_time
     */
    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 
     * @return
     *     The images
     */
    public Map<String, ResolutionDTO> getImages() {
        return images;
    }

    /**
     * 
     * @param images
     *     The images
     */
    public void setImages(Map<String, ResolutionDTO> images) {
        this.images = images;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The videos
     */
    public Map<String, ResolutionDTO> getVideos() {
        return videos;
    }

    /**
     * 
     * @param videos
     *     The videos
     */
    public void setVideos(Map<String, ResolutionDTO> videos) {
        this.videos = videos;
    }

}
