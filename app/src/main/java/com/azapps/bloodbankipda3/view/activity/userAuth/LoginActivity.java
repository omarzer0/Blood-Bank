package com.azapps.bloodbankipda3.view.activity.userAuth;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.helper.Utils;
import com.azapps.bloodbankipda3.view.fragment.userAuth.LoginFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Utils.replaceFragments(LoginFragment.newInstance(), getSupportFragmentManager());
    }


}