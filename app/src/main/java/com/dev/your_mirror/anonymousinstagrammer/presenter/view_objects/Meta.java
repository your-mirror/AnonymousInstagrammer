package com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects;


public class Meta {
    public final static int STATUS_OK = 200;

    private Integer code;

    public Meta(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
