package com.example.apiproject;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Organizer implements Parcelable {
    private String mal_id;
    private String url;
    private String title;
    private String image_url;
    private String synopsis;
    private String type;
    private String airing_start;
    private int episodes ;
    private int members;
    List<GenreOrganizer> genre ;
    private String source ;
    List<ProducerOrganizer> producer ;
    private String score;

    @Override
    public String toString() {
        return "Organizer{" +
                "mal_id='" + mal_id + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", type='" + type + '\'' +
                ", airing_start='" + airing_start + '\'' +
                ", episodes=" + episodes +
                ", members=" + members +
                ", genre=" + genre +
                ", source='" + source + '\'' +
                ", producer=" + producer +
                ", score='" + score + '\'' +
                '}';
    }

    public Organizer(){

    }


    protected Organizer(Parcel in) {
        mal_id = in.readString();
        url = in.readString();
        title = in.readString();
        image_url = in.readString();
        synopsis = in.readString();
        type = in.readString();
        airing_start = in.readString();
        episodes = in.readInt();
        members = in.readInt();
        genre = in.createTypedArrayList(GenreOrganizer.CREATOR);
        source = in.readString();
        producer = in.createTypedArrayList(ProducerOrganizer.CREATOR);
        score = in.readString();
    }

    public static final Creator<Organizer> CREATOR = new Creator<Organizer>() {
        @Override
        public Organizer createFromParcel(Parcel in) {
            return new Organizer(in);
        }

        @Override
        public Organizer[] newArray(int size) {
            return new Organizer[size];
        }
    };

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getEpisodes() { return episodes; }
    public void setEpisodes(int episodes) { this.episodes = episodes; }
    public String getAiring_start() { return airing_start; }
    public void setAiring_start(String airing_start) { this.airing_start = airing_start; }
    public String getSynopsis() { return synopsis; }
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }
    public String getScore() { return score; }
    public void setScore(String score) { this.score = score; }
    public String getImage_url() { return image_url; }
    public void setImage_url(String image_url) { this.image_url = image_url; }
    public String getMal_id() {
        return mal_id;
    }
    public void setMal_id(String mal_id) {
        this.mal_id = mal_id;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getMembers() {
        return members;
    }
    public void setMembers(int members) {
        this.members = members;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getGenre(){
        String listOfGenre = "";
        for(int i=0;i<genre.size()-1;i++){
            listOfGenre = listOfGenre + genre.get(i).getName()+", ";
        }
        return "placeholder";
    }
    public String getProducer(){
        String listOfProducer = "";
        for(int i=0;i<genre.size();i++){
            listOfProducer = listOfProducer + producer.get(i).getName()+", ";
        }
        return listOfProducer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mal_id);
        parcel.writeString(url);
        parcel.writeString(title);
        parcel.writeString(image_url);
        parcel.writeString(synopsis);
        parcel.writeString(type);
        parcel.writeString(airing_start);
        parcel.writeInt(episodes);
        parcel.writeInt(members);
        parcel.writeTypedList(genre);
        parcel.writeString(source);
        parcel.writeTypedList(producer);
        parcel.writeString(score);
    }
}
