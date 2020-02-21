package com.example.weather.retrofit;

import com.example.weather.utils.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {


    private RetrofitInstance(){

    }

        private static class RetrofitInstanceHolder{


            public static WeatherService weatherRetrofit(){
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                        interceptor.level(HttpLoggingInterceptor.Level.BODY);

                OkHttpClient client = new OkHttpClient.Builder()
                        .addInterceptor(interceptor)
                        .build();

                Retrofit result =
                        new Retrofit.Builder()
                                .client(client)
                                .baseUrl(Constants.BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                return result.create(WeatherService.class);
            }



        }
    public static WeatherService getInstance() {
        return RetrofitInstanceHolder.weatherRetrofit();
    }
}
