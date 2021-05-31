package com.azapps.bloodbankipda3.view.activity.home;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.helper.Utils;
import com.azapps.bloodbankipda3.view.fragment.home.bottomNavigationFragments.HomeFragment;
import com.azapps.bloodbankipda3.view.fragment.home.bottomNavigationFragments.MoreFragment;
import com.azapps.bloodbankipda3.view.fragment.home.bottomNavigationFragments.NotificationFragment;
import com.azapps.bloodbankipda3.view.fragment.home.bottomNavigationFragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    private int container = R.id.activity_home_container_frame_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Utils.replaceFragmentsWithoutBackStack(new HomeFragment(), getSupportFragmentManager(), container);

        BottomNavigationView bottomNavigationView = findViewById(R.id.activity_home_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = HomeFragment.newInstance();
                        break;

                    case R.id.nav_profile:
                        fragment = ProfileFragment.newInstance();
                        break;

                    case R.id.nav_notification:
                        fragment = NotificationFragment.newInstance();
                        break;

                    case R.id.nav_more:
                        fragment = MoreFragment.newInstance();
                        break;
                }
                Utils.replaceFragmentsWithoutBackStack(fragment,getSupportFragmentManager(),container);
                // true means yes i want it to be selected
                return true;
            }
        });
    }
}