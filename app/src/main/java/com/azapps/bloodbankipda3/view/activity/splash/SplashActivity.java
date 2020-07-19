package com.azapps.bloodbankipda3.view.activity.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.view.activity.home.HomeActivity;
import com.azapps.bloodbankipda3.view.activity.slider.SliderActivity;

import static com.azapps.bloodbankipda3.helper.Constant.PREFS_LOGIN_FILE_NAME;
import static com.azapps.bloodbankipda3.helper.Constant.PREF_LOGIN_CHECKBOX;

public class SplashActivity extends AppCompatActivity {
    public static final int SPLASH_DELAYED_LENGTH = 1000;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedPreferences = getSharedPreferences(PREFS_LOGIN_FILE_NAME, MODE_PRIVATE);
        final Boolean chkChecked = sharedPreferences.getBoolean(PREF_LOGIN_CHECKBOX, false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (chkChecked) {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                } else {
                    clearSharedPreferences();
                    startActivity(new Intent(SplashActivity.this, SliderActivity.class));
                }
                finish();
            }
        }, SPLASH_DELAYED_LENGTH);
    }

    private void clearSharedPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}