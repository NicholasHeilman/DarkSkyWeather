package com.example.weather.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weather.models.WeatherResponse;
import com.example.weather.repositories.Repository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;



public class MainViewModel extends ViewModel {



    private MutableLiveData<WeatherResponse> mWeather = new MutableLiveData<WeatherResponse>();
    private MutableLiveData<String> error = new MutableLiveData<>();

    private Repository repo = new Repository();

    public void fetchWeatherData(double latitude, double longitude) {
        repo.getCurrently(latitude, longitude)
                .enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> wResponse) {
                        if (wResponse.isSuccessful()) {
                            mWeather.postValue(wResponse.body());
                            Log.d(TAG, "onResponse: " + wResponse.body());
                        } else
                            Log.d(TAG, "onResponse: FAILURE" + wResponse.errorBody());
                    }

                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }



   public LiveData<WeatherResponse> fetchWeatherData(){
       return mWeather;
        }

    public LiveData<String> getErrorLiveData() {
        return error;
    }

}
