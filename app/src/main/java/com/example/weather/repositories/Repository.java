package com.example.weather.repositories;

import com.example.weather.models.WeatherResponse;
import com.example.weather.retrofit.RetrofitInstance;
import com.example.weather.retrofit.WeatherService;
import com.example.weather.utils.Constants;

import retrofit2.Call;

public class Repository {

    private WeatherService weatherService;

    public Repository(){
        weatherService = RetrofitInstance.getInstance();
    }

    public Call<WeatherResponse> getCurrently(double latitude, double longitude){

        return weatherService.getCurrently(Constants.KEY, latitude, longitude, Constants.exclude);

    }

}

