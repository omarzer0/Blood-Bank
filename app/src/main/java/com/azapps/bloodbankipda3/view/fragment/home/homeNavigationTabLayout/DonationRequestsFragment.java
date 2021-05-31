package com.azapps.bloodbankipda3.view.fragment.home.homeNavigationTabLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.azapps.bloodbankipda3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DonationRequestsFragment extends Fragment {
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_donation_requests, container, false);
        FloatingActionButton addDonationRequestFab = view.findViewById(R.id.fragment_tab_donation_requests_add_donation_request_fab);
        addDonationRequestFab.setOnClickListener(onClickListener);
        return view;
    }

    public static DonationRequestsFragment newInstance() {
        return new DonationRequestsFragment();
    }
}
