package com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String username;
    private String fullName;
    private String profilePicture;
    private long id;

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User(String username, String fullName, String profilePicture, long id) {
        this.username = username;
        this.fullName = fullName;
        this.profilePicture = profilePicture;
        this.id = id;
    }

    private User(Parcel parcel) {
        this.username = parcel.readString();
        this.fullName = parcel.readString();
        this.profilePicture = parcel.readString();
        this.id = parcel.readLong();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(fullName);
        parcel.writeString(profilePicture);
        parcel.writeLong(id);
    }
}
