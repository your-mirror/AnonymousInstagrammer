package com.dev.your_mirror.anonymousinstagrammer.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDTO {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("bio")
    @Expose
    private String bio;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("profile_picture")
    @Expose
    private String profilePicture;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("id")
    @Expose
    private long id;

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * The bio
     */
    public String getBio() {
        return bio;
    }

    /**
     *
     * @param bio
     * The bio
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     *
     * @return
     * The website
     */
    public String getWebsite() {
        return website;
    }

    /**
     *
     * @param website
     * The website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     *
     * @return
     * The profilePicture
     */
    public String getProfilePicture() {
        return profilePicture;
    }

    /**
     *
     * @param profilePicture
     * The profile_picture
     */
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    /**
     *
     * @return
     * The fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     *
     * @param fullName
     * The full_name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
