package com.example.weatherdemo.serviceapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit=null;
    private static final String BASE_URL="https://api.weatherapi.com/v1/";

    public RetrofitInstance(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public static WeatherApi getInstance(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(WeatherApi.class);
    }
}
