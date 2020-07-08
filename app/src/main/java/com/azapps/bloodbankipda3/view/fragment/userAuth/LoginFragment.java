package com.azapps.bloodbankipda3.view.fragment.userAuth;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.helper.Utils;
import com.azapps.bloodbankipda3.view.activity.home.HomeActivity;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private TextView forgetPassword, signUp;
    private Button login;

    public LoginFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        initViews(view);
        login.setOnClickListener(this);
        forgetPassword.setOnClickListener(this);
        signUp.setOnClickListener(this);

        return view;
    }


    private void initViews(View view) {
        forgetPassword = view.findViewById(R.id.activity_login_tv_text_view_forget_password);
        signUp = view.findViewById(R.id.activity_login_tv_text_view_sign_up);
        login = view.findViewById(R.id.activity_login_btn_login_button);
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_login_tv_text_view_forget_password:
                Utils.replaceFragments(ForgetPasswordFragment.newInstance(), getFragmentManager());
                break;
            case R.id.activity_login_btn_login_button:
                startActivity(new Intent(getActivity(), HomeActivity.class));
                break;
            case R.id.activity_login_tv_text_view_sign_up:
                Utils.replaceFragments(SignUpFragment.newInstance(), getFragmentManager());
                break;
        }
    }

}
