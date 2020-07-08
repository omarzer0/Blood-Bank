package com.azapps.bloodbankipda3.view.fragment.userAuth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.azapps.bloodbankipda3.R;

public class ConfirmForgetPasswordFragment extends Fragment {
    public ConfirmForgetPasswordFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirm_password, container, false);
    }

    public static ConfirmForgetPasswordFragment newInstance() {
        return new ConfirmForgetPasswordFragment();
    }

}
