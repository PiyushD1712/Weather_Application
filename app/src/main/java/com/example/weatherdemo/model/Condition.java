package com.example.weatherdemo.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Condition {
    @SerializedName("text")
    @Expose
    private String condText;
    @SerializedName("icon")
    @Expose
    private String icon;
    public String getCondText() {
        return condText;
    }
    public void setCondText(String condText) {
        this.condText = condText;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
}
