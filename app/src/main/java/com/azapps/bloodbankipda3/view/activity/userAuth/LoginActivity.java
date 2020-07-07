package com.azapps.bloodbankipda3.view.activity.userAuth;

import android.os.Bundle;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.view.activity.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }
}