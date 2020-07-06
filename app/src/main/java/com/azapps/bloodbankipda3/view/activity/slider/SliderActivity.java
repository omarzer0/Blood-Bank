package com.azapps.bloodbankipda3.view.activity.slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.adapter.slider.SliderViewPagerAdapter;
import com.azapps.bloodbankipda3.view.activity.BaseActivity;
import com.google.android.material.tabs.TabLayout;

public class SliderActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        ViewPager viewPager = findViewById(R.id.activity_slider_view_pager);
        TabLayout tabLayout = findViewById(R.id.activity_slider_tab_layout_3_dots);
        SliderViewPagerAdapter adapter = new SliderViewPagerAdapter(getSupportFragmentManager(), SliderViewPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}