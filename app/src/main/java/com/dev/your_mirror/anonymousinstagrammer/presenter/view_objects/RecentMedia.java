package com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects;


import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Map;
import java.util.Set;

public class RecentMedia implements Parcelable {
    public enum Type {
        IMAGE,
        VIDEO
    }

    public static final Parcelable.Creator<RecentMedia> CREATOR = new Parcelable.Creator<RecentMedia>() {
        @Override
        public RecentMedia createFromParcel(Parcel parcel) {
            return new RecentMedia(parcel);
        }

        @Override
        public RecentMedia[] newArray(int size) {
            return new RecentMedia[size];
        }
    };

    public RecentMedia(
        String id, long createdTime, Type type, User user,
        Map<Resolution.TYPE, Resolution> images, Map<Resolution.TYPE, Resolution> videos) {
        this.id = id;
        this.createdTime = createdTime;
        this.type = type;
        this.user = user;
        this.images = images;
        this.videos = videos;
    }

    private RecentMedia(Parcel parcel) {
        this.id = parcel.readString();
        this.createdTime = parcel.readLong();
        this.type = Type.valueOf(parcel.readString());
        this.user = parcel.readParcelable(User.class.getClassLoader());

        String[] imagesKeys = parcel.createStringArray();
        Bundle imagesBundle = parcel.readBundle(Resolution.class.getClassLoader());
        for (String key : imagesKeys) {
            images.put(
                Resolution.TYPE.valueOf(key),
                Resolution.class.cast(imagesBundle.getParcelable(key))
            );
        }
    }

    private Type type;
    private long createdTime;
    private String id;
    private User user;
    private Map<Resolution.TYPE, Resolution> videos;
    private Map<Resolution.TYPE, Resolution> images;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Resolution.TYPE, Resolution> getVideos() {
        return videos;
    }

    public void setVideos(Map<Resolution.TYPE, Resolution> videos) {
        this.videos = videos;
    }

    public Map<Resolution.TYPE, Resolution> getImages() {
        return images;
    }

    public void setImages(Map<Resolution.TYPE, Resolution> images) {
        this.images = images;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeLong(createdTime);
        parcel.writeString(type.name());
        parcel.writeParcelable(user, i);

        Bundle imagesBundle = new Bundle();
        for (Map.Entry<Resolution.TYPE, Resolution> entry : images.entrySet()) {
            imagesBundle.putParcelable(entry.getKey().name(), entry.getValue());
        }
        final Set<Resolution.TYPE> imagesSet = images.keySet();
        final String[] array = imagesSet.toArray(new String[imagesSet.size()]);
        parcel.writeStringArray(array);
        parcel.writeBundle(imagesBundle);
    }
}
