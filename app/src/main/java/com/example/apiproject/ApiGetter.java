package com.example.apiproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiGetter {

    String BASE_URL = "http://www.recipepuppy.com/";

    @GET("api")
    Call<Orginaizer> getRecipes(@Query("i") String ingredients, @Query("q") String search);


}
