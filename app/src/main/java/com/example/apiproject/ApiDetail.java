package com.example.apiproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ApiDetail extends AppCompatActivity {
    private TextView title;
    private TextView genre;
    private TextView synopsis;
    private TextView episodes;
    private TextView producer;
    private TextView season;
    private TextView malScore;
    private Organizer anime;
    private ImageView card;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_api_detail);
        Intent lastIntent = getIntent();
        anime = lastIntent.getParcelableExtra(MainActivity.EXTRA_ANIME);
        wireWidgets();
        setString();
    }

    private void setString() {
        Picasso.get().load(anime.getImage_url()).into(card);
        title.setText(anime.getTitle());
        genre.setText(anime.getGenre());
        synopsis.setText(anime.getSynopsis());
        episodes.setText(anime.getEpisodes());
        producer.setText(anime.getProducer());
        season.setText(anime.getAiring_start());
        malScore.setText(anime.getScore());


    }

    private void wireWidgets() {
        title = findViewById(R.id.textView_detail_animeTitle);
        genre = findViewById(R.id.textView_detail_animeGenre);
        synopsis = findViewById(R.id.textView_detail_animeSynopsis);
        episodes = findViewById(R.id.textView_detail_animeEpisodeLength);
        producer = findViewById(R.id.textView_detail_animeProducer);
        season = findViewById(R.id.textView_detail_animeSeasonAired);
        malScore = findViewById(R.id.textView_detail_animeMalScore);
        card = findViewById(R.id.imageView_detail_animeTitleCard);
    }
}

