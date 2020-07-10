package com.azapps.bloodbankipda3.view.fragment.userAuth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.helper.Utils;

public class ForgetPasswordFragment extends Fragment implements View.OnClickListener {
    Button senVerificationCodeBtn;

    public ForgetPasswordFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forget_password, container, false);
        senVerificationCodeBtn = view.findViewById(R.id.fragment_forget_password_btn_send_verification_code_button);
        senVerificationCodeBtn.setOnClickListener(this);
        return view;
    }

    public static ForgetPasswordFragment newInstance() {
        return new ForgetPasswordFragment();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_forget_password_btn_send_verification_code_button:
                Utils.replaceFragments(ConfirmForgetPasswordFragment.newInstance(),getFragmentManager());
                break;
        }
    }
}
