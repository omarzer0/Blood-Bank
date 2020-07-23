package com.azapps.bloodbankipda3.view.fragment.home.bottomNavigationFragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.azapps.bloodbankipda3.R;

import static android.content.Context.MODE_PRIVATE;
import static com.azapps.bloodbankipda3.helper.Constant.PREFS_LOGIN_FILE_NAME;
import static com.azapps.bloodbankipda3.helper.Constant.PREF_API_TOKEN;

public class ProfileFragment extends Fragment {
    // ui
    private TextView dateOfBirthTV, bloodTypeTV, lastDonationDateTV, stateTV, cityTV;
    private EditText nameET, emailET, phoneET, newPasswordET, confirmNewPasswordET;
    // vars
    private String name, email, dateOfBirth, lastDonation, phone, newPassword, confirmNewPassword;
    private int state, city;
    private String api_token;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_edit_profile, container, false);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(PREFS_LOGIN_FILE_NAME, MODE_PRIVATE);
        api_token = sharedPreferences.getString(PREF_API_TOKEN,null);



        return view;
    }

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }
}
