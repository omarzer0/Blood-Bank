package com.azapps.bloodbankipda3.view.fragment.userAuth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.data.DataHolder;
import com.azapps.bloodbankipda3.data.UserLoginDataBody;
import com.azapps.bloodbankipda3.helper.Utils;
import com.azapps.bloodbankipda3.helper.retrofitCalls.DataApi;
import com.azapps.bloodbankipda3.view.activity.home.HomeActivity;
import com.azapps.bloodbankipda3.view.activity.userAuth.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.azapps.bloodbankipda3.helper.Constant.PREFS_LOGIN_FILE_NAME;

public class LoginFragment extends Fragment implements View.OnClickListener, LoginActivity.OnBackPressedListener {
    private static final String TAG = "LoginFragment";
    private static final String PREF_PHONE = "phone";
    private static final String PREF_PASSWORD = "password";
    private static final String PREF_CHECKBOX = "password";
    // ui
    private TextView forgetPassword, signUp;
    private Button login;
    private CheckBox rememberMeCHK;
    private EditText phoneETField, passwordETField;

    // var
    private String phone, password;
    private boolean chkChecked;
    private DataApi dataApi;

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
        rememberMeCHK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    chkChecked = true;
                } else if (!buttonView.isChecked()) {
                    chkChecked = false;
                }
            }
        });

        return view;
    }


    private void initViews(View view) {
        forgetPassword = view.findViewById(R.id.fragment_login_tv_text_view_forget_password);
        signUp = view.findViewById(R.id.fragment_login_tv_text_view_sign_up);
        login = view.findViewById(R.id.fragment_login_btn_login_button);
        rememberMeCHK = view.findViewById(R.id.fragment_login_chb_check_box_remember_me);
        phoneETField = view.findViewById(R.id.fragment_login_ed_edit_text_login_phone);
        passwordETField = view.findViewById(R.id.fragment_login_ed_edit_text_login_password);


    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onClick(View v) {
        // var
        int container = R.id.activity_login_frame_layout;
        switch (v.getId()) {
            case R.id.fragment_login_tv_text_view_forget_password:
                Utils.replaceFragments(ForgetPasswordFragment.newInstance(), getFragmentManager(), container);
                break;
            case R.id.fragment_login_btn_login_button:
                checkIfEmailAndPasswordIsCorrect();
                break;
            case R.id.fragment_login_tv_text_view_sign_up:
                Utils.replaceFragments(SignUpFragment.newInstance(), getFragmentManager(), container);
                break;
        }
    }

    private void checkIfEmailAndPasswordIsCorrect() {
        phone = phoneETField.getText().toString().trim();
        password = passwordETField.getText().toString().trim();

        if (phone.equals("") || phone.isEmpty()) {
            phoneETField.setError("Enter Phone Number");
            Toast.makeText(getActivity(), "Please enter an Phone Number!", Toast.LENGTH_SHORT).show();
        } else if (password.equals("") || password.isEmpty()) {
            Toast.makeText(getActivity(), "Please enter a Password", Toast.LENGTH_SHORT).show();
        } else {
            // send request to see if this email and pass exists
            dataApi = Utils.createRetrofit();
            getResultsFromRetrofit();
        }
    }

    private void getResultsFromRetrofit() {
        Call<DataHolder> call = dataApi.getDataHolder(new UserLoginDataBody(phone, password));
        call.enqueue(new Callback<DataHolder>() {
            @Override
            public void onResponse(Call<DataHolder> call, Response<DataHolder> response) {
                if (!response.isSuccessful()) {
                    // no internet
                    Toast.makeText(getActivity(), "failed to connect to the server", Toast.LENGTH_SHORT).show();
                } else {
                    // successfully fetched data>>> check if it is right
                    getResponseStatus(response.body().getStatus(), response.body().getMsg());
                }
            }

            @Override
            public void onFailure(Call<DataHolder> call, Throwable t) {
                Toast.makeText(getActivity(), "check your network connection"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getResponseStatus(Integer status, String msg) {
        if (status == 0) {
            // no user with that phone and / or password
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        } else if (status == 1) {
            // log in / save the phone and pass and checkbox status
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
            saveToPreferences();
            // send the user to HomeActivity
            startActivity(new Intent(getActivity(), HomeActivity.class));
        }else {
            Toast.makeText(getActivity(), "wrong status", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveToPreferences() {
        SharedPreferences.Editor editor = getContext().getSharedPreferences(PREFS_LOGIN_FILE_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(PREF_PHONE, phone);
        editor.putString(PREF_PASSWORD, password);
        editor.putBoolean(PREF_CHECKBOX, chkChecked);
    }

    @Override
    public boolean onBackPressed() {
        return true;
    }
}
