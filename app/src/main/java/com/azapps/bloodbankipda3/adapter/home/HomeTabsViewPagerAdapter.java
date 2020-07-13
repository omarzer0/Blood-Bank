package com.azapps.bloodbankipda3.adapter.home;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.view.fragment.home.homeNavigationTabLayout.ArticleFragment;
import com.azapps.bloodbankipda3.view.fragment.home.homeNavigationTabLayout.DonationRequestsFragment;

public class HomeTabsViewPagerAdapter extends FragmentPagerAdapter {

    private static final int[] TAB_TITLES = new int[]{R.string.articales_tab,R.string.donation_requests};
    private Context context;

    public HomeTabsViewPagerAdapter(@NonNull FragmentManager fm, int behavior, Context context) {
        super(fm, behavior);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0 :
                fragment = ArticleFragment.newInstance();
                break;
            case 1 :
                fragment = DonationRequestsFragment.newInstance();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return context.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }
}
