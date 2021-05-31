package com.azapps.bloodbankipda3.view.activity.slider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.adapter.slider.SliderViewPagerAdapter;
import com.azapps.bloodbankipda3.view.activity.userAuth.LoginActivity;
import com.google.android.material.tabs.TabLayout;

public class SliderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        TextView skipButton = findViewById(R.id.item_slide_tv_skip);
        skipButton.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SliderActivity.this, LoginActivity.class));
            }
        });

        ViewPager viewPager = findViewById(R.id.activity_slider_view_pager);
        TabLayout tabLayout = findViewById(R.id.activity_slider_tab_layout_3_dots);
        SliderViewPagerAdapter adapter = new SliderViewPagerAdapter(getSupportFragmentManager(), SliderViewPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        tabLayout.setupWithViewPager(viewPager);
    }
}