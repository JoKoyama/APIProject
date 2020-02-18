package com.example.apiproject;

import android.os.Parcel;
import android.os.Parcelable;

public class ProducerOrganizer implements Parcelable {
    private String mal_id;
    private String type;
    private String name;
    private String url;


    public ProducerOrganizer(){


    }

    protected ProducerOrganizer(Parcel in) {
        mal_id = in.readString();
        type = in.readString();
        name = in.readString();
        url = in.readString();
    }

    public static final Creator<ProducerOrganizer> CREATOR = new Creator<ProducerOrganizer>() {
        @Override
        public ProducerOrganizer createFromParcel(Parcel in) {
            return new ProducerOrganizer(in);
        }

        @Override
        public ProducerOrganizer[] newArray(int size) {
            return new ProducerOrganizer[size];
        }
    };

    public String getMal_id() {
        return mal_id;
    }

    public void setMal_id(String mal_id) {
        this.mal_id = mal_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mal_id);
        parcel.writeString(type);
        parcel.writeString(name);
        parcel.writeString(url);
    }
}
