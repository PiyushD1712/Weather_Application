package com.example.weatherdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.weatherdemo.databinding.ActivityMainBinding;
import com.example.weatherdemo.model.Condition;
import com.example.weatherdemo.model.Current;
import com.example.weatherdemo.model.Location;
import com.example.weatherdemo.viewmodel.MyViewModel;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    ActivityMainBinding activityMainBinding;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        imageView = activityMainBinding.imageWeather;

        EditText editText = findViewById(R.id.idEdittext);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = editText.getText().toString();
                fetchData(str);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void fetchData(String perimeter){
        myViewModel.getLocation(perimeter).observe(this, new Observer<Location>() {
            @Override
            public void onChanged(Location location) {
                activityMainBinding.setLoc(location);
            }
        });
        myViewModel.getCurrent(perimeter).observe(this, new Observer<Current>() {
            @Override
            public void onChanged(Current current) {
                activityMainBinding.setCurr(current);
            }
        });
        myViewModel.getCondition(perimeter).observe(this, new Observer<Condition>() {
            @Override
            public void onChanged(Condition condition) {
                Glide.with(imageView.getContext()).load("https:"+condition.getIcon()).into(imageView);
                activityMainBinding.setCond(condition);
            }
        });
    }
}