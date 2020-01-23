package com.example.apiproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiGetter {

    String BASE_URL = "https://api.jikan.moe/v3/";

    @GET("search/anime")
    Call<Organizer> getShow(@Query("q") String showName);

    @GET("season/{season}/{year}")
    Call<Organizer> getSeason(@Path("season") String season, @Path("year") Integer year);


}
