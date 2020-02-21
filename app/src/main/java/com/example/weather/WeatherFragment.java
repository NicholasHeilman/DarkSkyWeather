package com.example.weather;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weather.models.Currently;
import com.example.weather.models.DataItem;
import com.example.weather.models.WeatherResponse;
import com.example.weather.viewmodels.MainViewModel;
import com.example.weather.MainActivity;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {

    private MainViewModel mainViewModel;
    private MainActivity mainActivity;
    private TextView tvTemperature;
    private ImageView ivIcon;
    private TextView tvSummary;
    private TextView tvTemperatureHigh;
    private TextView tvTemperatureLow;

    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        mainViewModel = new ViewModelProvider.NewInstanceFactory().create(MainViewModel.class);


        tvTemperature = view.findViewById(R.id.tvTemperature);
        ivIcon = view.findViewById(R.id.ivIcon);
        tvSummary = view.findViewById(R.id.tvSummary);
        tvTemperatureHigh = view.findViewById(R.id.tvTemperatureHigh);
        tvTemperatureLow = view.findViewById(R.id.tvTemperatureLow);
        setupObservers();
        Log.d(TAG, "onCreateView: IS this running!!!!!!!");
        mainViewModel.fetchWeatherData( 39.9495312,-75.1662117 );



//        39.9495312,-75.1662117


        return view;
    }//end onCreateView

    private void setupObservers(){
        mainViewModel.fetchWeatherData().observe(getViewLifecycleOwner(), new Observer<WeatherResponse>() {
            @Override
            public void onChanged(WeatherResponse weatherResponse) {
                Log.d(TAG, "onChanged: !!!!!!"+ weatherResponse.getDaily());
                tvTemperature.setText( String.valueOf(Math.round(weatherResponse.getCurrently().getTemperature())));
//                tvTemperatureHigh.setText( String.valueOf(Math.round(weatherResponse.get)));
            }
        });
    }
}
