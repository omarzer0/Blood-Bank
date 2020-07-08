package com.azapps.bloodbankipda3.view.fragment.userAuth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.azapps.bloodbankipda3.R;

public class ForgetPasswordFragment extends Fragment {
    public ForgetPasswordFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forget_password, container, false);
    }

    public static ForgetPasswordFragment newInstance() {
        return new ForgetPasswordFragment();
    }

}
