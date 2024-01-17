package com.example.weatherdemo.model;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.weatherdemo.R;
import com.example.weatherdemo.serviceapi.RetrofitInstance;
import com.example.weatherdemo.serviceapi.WeatherApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepo {
    private Application application;
    private Location location;
    private Current current;
    private Condition condition;

    private MutableLiveData<Location> locationMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Current> currentMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Condition> conditionMutableLiveData = new MutableLiveData<>();
    private final WeatherApi weatherApi;


    public WeatherRepo(Application application) {
        this.application = application;
        weatherApi = RetrofitInstance.getInstance();
        location= new Location();
        current = new Current();
        condition = new Condition();
    }
    public MutableLiveData<Location> getLocationMutableLiveData(String perimeter){
        Call<WeatherData> call = weatherApi.getWeather(application.getApplicationContext().getString(R.string.api_key),perimeter);
        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                WeatherData weatherData = response.body();
                if(weatherData!=null && weatherData.getLocation()!=null){
                    location=weatherData.getLocation();
                    locationMutableLiveData.setValue(location);
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(application.getApplicationContext(), "No matching location found.", Toast.LENGTH_SHORT).show();
            }
        });
        return locationMutableLiveData;
    }

    public MutableLiveData<Current> getCurrentMutableLiveData(String perimeter) {
        Call<WeatherData> call = weatherApi.getWeather(application.getApplicationContext().getString(R.string.api_key),perimeter);
        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                WeatherData weatherData = response.body();
                if(weatherData!=null && weatherData.getCurrent()!=null){
                    current = weatherData.getCurrent();
                    currentMutableLiveData.setValue(current);
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return currentMutableLiveData;
    }

    public MutableLiveData<Condition> getConditionMutableLiveData(String perimeter) {
        Call<WeatherData> call = weatherApi.getWeather(application.getApplicationContext().getString(R.string.api_key),perimeter);
        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                WeatherData weatherData= response.body();
                if(weatherData!=null && weatherData.getCurrent().getCondition()!=null){
                    condition = weatherData.getCurrent().getCondition();
                    conditionMutableLiveData.setValue(condition);
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return conditionMutableLiveData;
    }
}
