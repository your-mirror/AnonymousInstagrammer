package com.dev.your_mirror.anonymousinstagrammer.model.dto;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetaDTO {

    @SerializedName("code")
    @Expose
    private Integer code;

    /**
     * 
     * @return
     *     The code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

}
