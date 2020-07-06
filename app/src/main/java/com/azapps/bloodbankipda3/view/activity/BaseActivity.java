package com.azapps.bloodbankipda3.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.azapps.bloodbankipda3.view.fragment.BaseFragment;

public class BaseActivity extends AppCompatActivity {
    public BaseFragment baseFragment;

    public void superOnBackPressed() {
        // for super back function
        super.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        // your custom action from the fragment
        finishAffinity();
    }
}
