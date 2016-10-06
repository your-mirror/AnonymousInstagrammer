package com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects;


import android.os.Parcel;
import android.os.Parcelable;

public class Resolution implements Parcelable {
    public enum TYPE {
        THUMBNAIL,
        LOW_RESOLUTION,
        STANDARD
    }

    private String url;
    private Integer width;
    private Integer height;

    private static final Parcelable.Creator<Resolution> CREATOR = new Parcelable.Creator<Resolution>() {
        @Override
        public Resolution createFromParcel(Parcel parcel) {
            return new Resolution(parcel);
        }

        @Override
        public Resolution[] newArray(int size) {
            return new Resolution[size];
        }
    };

    public Resolution(String url, Integer width, Integer height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    private Resolution(Parcel parcel) {
        parcel.writeString(url);
        parcel.writeInt(width);
        parcel.writeInt(height);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(url);
        parcel.writeInt(width);
        parcel.writeInt(height);
    }
}
