package com.example.apiproject;

import android.os.Parcel;
import android.os.Parcelable;

public class GenreOrganizer implements Parcelable {
    private String type = "";
    private int mal_id = 0;
    private String name = "";
    private String url = "";


    public GenreOrganizer(){


    }


    protected GenreOrganizer(Parcel in) {
        type = in.readString();
        mal_id = in.readInt();
        name = in.readString();
        url = in.readString();
    }

    public static final Creator<GenreOrganizer> CREATOR = new Creator<GenreOrganizer>() {
        @Override
        public GenreOrganizer createFromParcel(Parcel in) {
            return new GenreOrganizer(in);
        }

        @Override
        public GenreOrganizer[] newArray(int size) {
            return new GenreOrganizer[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMal_id() {
        return mal_id;
    }

    public void setMal_id(int mal_id) {
        this.mal_id = mal_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(type);
        parcel.writeInt(mal_id);
        parcel.writeString(name);
        parcel.writeString(url);
    }
}
