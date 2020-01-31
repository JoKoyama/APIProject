package com.example.apiproject;

import java.util.ArrayList;

public class WrapperOrganizer {
    private ArrayList<Organizer> anime;

    public WrapperOrganizer() {

    }

    public ArrayList<Organizer> getAnime() {
        return anime;
    }
    public void setAnime(ArrayList<Organizer> anime) {
        this.anime = anime;
    }

    @Override
    public String toString() {
        return anime.get(1).getTitle();
    }
}
