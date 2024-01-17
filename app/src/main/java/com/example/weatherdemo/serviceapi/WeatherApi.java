package com.example.weatherdemo.serviceapi;

import com.example.weatherdemo.model.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("current.json")
    Call<WeatherData> getWeather(@Query("key") String apiKey,@Query("q") String location);
}
