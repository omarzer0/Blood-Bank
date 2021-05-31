package com.azapps.bloodbankipda3.view.activity.userAuth;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.helper.Utils;
import com.azapps.bloodbankipda3.view.fragment.userAuth.LoginFragment;

public class LoginActivity extends AppCompatActivity {
    private int container = R.id.activity_login_frame_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Utils.replaceFragments(LoginFragment.newInstance(), getSupportFragmentManager(),container);
    }

    @Override
    public void onBackPressed() {
        // return true to exit the app .......... true to remove the previous fragment
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.activity_login_frame_layout);
        if(!(fragment instanceof  OnBackPressedListener)|| !((OnBackPressedListener)fragment).onBackPressed()){
            super.onBackPressed();
        }else {
            finishAffinity();
        }
    }

    public interface OnBackPressedListener{
        boolean onBackPressed();
    }
}