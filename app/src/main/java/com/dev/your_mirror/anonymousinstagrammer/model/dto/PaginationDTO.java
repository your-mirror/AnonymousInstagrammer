package com.dev.your_mirror.anonymousinstagrammer.model.dto;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaginationDTO {
    @SerializedName("next_url")
    @Expose
    private String nextUrl;
    @SerializedName("next_max_id")
    @Expose
    private String nextMaxId;

    /**
     *
     * @return
     * The nextUrl
     */
    public String getNextUrl() {
        return nextUrl;
    }

    /**
     *
     * @param nextUrl
     * The next_url
     */
    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    /**
     *
     * @return
     * The nextMaxId
     */
    public String getNextMaxId() {
        return nextMaxId;
    }

    /**
     *
     * @param nextMaxId
     * The next_max_id
     */
    public void setNextMaxId(String nextMaxId) {
        this.nextMaxId = nextMaxId;
    }
}
