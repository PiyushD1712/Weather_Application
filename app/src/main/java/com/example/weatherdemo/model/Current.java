package com.example.weatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Current {
    @SerializedName("temp_c")
    @Expose
    private Double tempC;
    @SerializedName("condition")
    @Expose
    private Condition condition;
    @SerializedName("wind_kph")
    @Expose
    private Double windSpeed;
    @SerializedName("humidity")
    @Expose
    private Double humidity;
    @SerializedName("vis_km")
    @Expose
    private Double visibility;
    @SerializedName("feelslike_c")
    @Expose
    private Double feelsLikeC;

    public Double getFeelsLikeC() {
        return feelsLikeC;
    }

    public void setFeelsLikeC(Double feelsLikeC) {
        this.feelsLikeC = feelsLikeC;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Double getTempC() {
        return tempC;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setTempC(Double tempC) {
        this.tempC = tempC;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
