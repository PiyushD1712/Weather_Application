package com.example.weatherdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.weatherdemo.model.Condition;
import com.example.weatherdemo.model.Current;
import com.example.weatherdemo.model.Location;
import com.example.weatherdemo.model.WeatherRepo;

public class MyViewModel extends AndroidViewModel {
    private WeatherRepo weatherRepo;

    public MyViewModel(@NonNull Application application) {
        super(application);
        this.weatherRepo = new WeatherRepo(application);
    }
    public LiveData<Location> getLocation(String perimeter){
        return weatherRepo.getLocationMutableLiveData(perimeter);
    }
    public LiveData<Current> getCurrent(String perimeter){
        return weatherRepo.getCurrentMutableLiveData(perimeter);
    }
    public LiveData<Condition> getCondition(String perimeter){
        return weatherRepo.getConditionMutableLiveData(perimeter);
    }
}
