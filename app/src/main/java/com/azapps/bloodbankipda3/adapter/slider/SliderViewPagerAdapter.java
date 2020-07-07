package com.azapps.bloodbankipda3.adapter.slider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.azapps.bloodbankipda3.view.fragment.slider.SliderFragment;

public class SliderViewPagerAdapter extends FragmentPagerAdapter {


    public SliderViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        SliderFragment sliderFragment = new SliderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        sliderFragment.setArguments(bundle);
        return sliderFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
