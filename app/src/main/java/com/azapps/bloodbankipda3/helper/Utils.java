package com.azapps.bloodbankipda3.helper;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.azapps.bloodbankipda3.R;

public class Utils {

    public static void replaceFragments(Fragment fragment, FragmentManager fragmentManager) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.activity_login_frame_layout, fragment)
                .addToBackStack(null)
                .commit();
    }
}
