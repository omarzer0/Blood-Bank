package com.azapps.bloodbankipda3.view.fragment.home.bottomNavigationFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.adapter.home.HomeTabsViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        HomeTabsViewPagerAdapter homeTabsViewPagerAdapter = new HomeTabsViewPagerAdapter(getChildFragmentManager(), HomeTabsViewPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, getActivity());
        ViewPager homeTabViewPager = view.findViewById(R.id.fragment_home_view_pager);
        homeTabViewPager.setAdapter(homeTabsViewPagerAdapter);
        TabLayout tabLayout = view.findViewById(R.id.fragment_home_tab_layout);
        tabLayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        tabLayout.setupWithViewPager(homeTabViewPager);
        return view;
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
}
