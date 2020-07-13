package com.azapps.bloodbankipda3.view.activity.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.view.activity.slider.SliderActivity;

public class SplashActivity extends AppCompatActivity {
    public static final int SPLASH_DELAYED_LENGTH = 500 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, SliderActivity.class));
                finish();
            }
        },SPLASH_DELAYED_LENGTH );
    }
}