package com.example.weather.retrofit;

import com.example.weather.models.WeatherResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {


        @GET("forecast/{key}/{latitude},{longitude}")
        Call<WeatherResponse> getCurrently(
            @Path("key") String KEY,
            @Path("latitude") double latitude,
            @Path("longitude") double longitude,
            @Query("exclude") String exclude
        );
        
}
