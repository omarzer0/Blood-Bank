package com.azapps.bloodbankipda3.view.activity;

import android.os.Bundle;

import com.azapps.bloodbankipda3.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }
}