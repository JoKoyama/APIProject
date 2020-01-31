package com.example.apiproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiGetter {

    String BASE_URL = "https://api.jikan.moe/v3/";

    @GET("search/anime")
    Call<WrapperOrganizer> getShow(@Query("q") String showName);

    @GET("season/{year}/{season}")
    Call<WrapperOrganizer> getSeason(@Path("season") String season, @Path("year") int year);




}
