package com.azapps.bloodbankipda3.view.activity.home;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Utils.replaceFragmentsWithoutBackStack(new HomeFragment(), getSupportFragmentManager(), container);
                        break;

                    case R.id.nav_profile:
                        Utils.replaceFragmentsWithoutBackStack(new ProfileFragment(),getSupportFragmentManager(),container);
                        break;

                    case R.id.nav_notification:
                        Utils.replaceFragmentsWithoutBackStack(new NotificationFragment(),getSupportFragmentManager(),container);
                        break;

                    case R.id.nav_more:
                        Utils.replaceFragmentsWithoutBackStack(new MoreFragment(),getSupportFragmentManager(),container);
                        break;
                }
                // true means yes i want it to be selected
                return true;
            }
        });
    }
}