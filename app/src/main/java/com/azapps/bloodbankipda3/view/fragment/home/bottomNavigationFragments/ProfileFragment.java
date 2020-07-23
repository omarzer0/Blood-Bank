package com.azapps.bloodbankipda3.view.fragment.home.bottomNavigationFragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.data.Client;
import com.azapps.bloodbankipda3.data.RetrofitCallStatus;
import com.azapps.bloodbankipda3.helper.Utils;
import com.azapps.bloodbankipda3.helper.retrofitCalls.DataApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;
import static com.azapps.bloodbankipda3.helper.Constant.PREFS_LOGIN_FILE_NAME;
import static com.azapps.bloodbankipda3.helper.Constant.PREF_API_TOKEN;

public class ProfileFragment extends Fragment {
    private static final String PREFS_SAVE_USER_PROFILE_INFO_FILE_NAME = "ProfileFile";
    private static final String PREFS_SAVE_USER_PROFILE_INFO_USER_NAME = "UserName";
    private static final String PREFS_SAVE_USER_PROFILE_INFO_USER_EMAIL = "UserEmail";
    private static final String PREFS_SAVE_USER_PROFILE_INFO_DATE_OF_BIRTH = "DateOfBirth";
    private static final String PREFS_SAVE_USER_PROFILE_INFO_BLOOD_TYPE = "BloodType";
    private static final String PREFS_SAVE_USER_PROFILE_INFO_LAST_DONATION = "LastDonation";
    private static final String PREFS_SAVE_USER_PROFILE_INFO_STATE = "State";
    private static final String PREFS_SAVE_USER_PROFILE_INFO_CITY = "City";
    private static final String PREFS_SAVE_USER_PROFILE_INFO_PHONE = "Phone";
    // ui
    private TextView dateOfBirthTV, bloodTypeTV, lastDonationDateTV, stateTV, cityTV;
    private EditText nameET, emailET, phoneET;
    // vars
    private String name, email, dateOfBirth, lastDonation, stateName, stateId, cityName, cityId, bloodTypeChoice, bloodTypeChoiceId, phone;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);

        nameET = view.findViewById(R.id.fragment_edit_profile_ed_edit_text_name);
        emailET = view.findViewById(R.id.fragment_edit_profile_ed_edit_text_email);

        dateOfBirthTV = view.findViewById(R.id.fragment_edit_profile_tv_text_view_date_of_birth);
        bloodTypeTV = view.findViewById(R.id.fragment_edit_profile_tv_text_view_blood_type_choice);
        lastDonationDateTV = view.findViewById(R.id.fragment_edit_profile_tv_text_view_last_blood_donation);

        stateTV = view.findViewById(R.id.fragment_edit_profile_tv_text_view_state_location);
        cityTV = view.findViewById(R.id.fragment_edit_profile_tv_text_view_city_location);
        phoneET = view.findViewById(R.id.fragment_edit_profile_ed_edit_text_phone);

        preferences = getContext().getSharedPreferences(PREFS_SAVE_USER_PROFILE_INFO_FILE_NAME, MODE_PRIVATE);
        editor = preferences.edit();
        // login preference
        SharedPreferences loginFileSharedPreference = getContext().getSharedPreferences(PREFS_LOGIN_FILE_NAME, MODE_PRIVATE);
        String api_token = loginFileSharedPreference.getString(PREF_API_TOKEN, null);

        if (preferences.getString(PREFS_SAVE_USER_PROFILE_INFO_USER_NAME, null) == null) {
            getProfileDataFromRetrofit(api_token);
        } else {
            setProfilePreferenceDataToVariables();
            setProfileDataToViews(name, email, dateOfBirth, bloodTypeChoice, lastDonation, stateName, cityName, phone);
        }
        return view;
    }

    private void getProfileDataFromRetrofit(String api_token) {
        DataApi dataApi = Utils.createRetrofit();
        Call<RetrofitCallStatus> call = dataApi.getUserProfileData("Xp2fERl2yEMCSIusVjdqH6EjU51jd1s5cwi93Xy2dDqNFZBJ3Mu4JJFwJeVU");
        call.enqueue(new Callback<RetrofitCallStatus>() {
            @Override
            public void onResponse(Call<RetrofitCallStatus> call, Response<RetrofitCallStatus> response) {
                if (!response.isSuccessful()) {
                    // Server error
                    Toast.makeText(getActivity(), "failed to connect to the server", Toast.LENGTH_SHORT).show();
                } else {
                    // successfully fetched data>>> check status if it is right
                    checkForComingDataStatus(response.body());
                }
            }

            @Override
            public void onFailure(Call<RetrofitCallStatus> call, Throwable t) {
                Toast.makeText(getActivity(), "check your network connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkForComingDataStatus(RetrofitCallStatus body) {
        int status = body.getStatus();
        String msg = body.getMsg();
        if (status == 0) {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        } else if (status == 1) {
            Client client = body.getData().getClient();
            setProfileClientDataToVariables(client);
        }
    }

    private void setProfilePreferenceDataToVariables() {
        name = preferences.getString(PREFS_SAVE_USER_PROFILE_INFO_USER_NAME, null);
        email = preferences.getString(PREFS_SAVE_USER_PROFILE_INFO_USER_EMAIL, null);
        dateOfBirth = preferences.getString(PREFS_SAVE_USER_PROFILE_INFO_DATE_OF_BIRTH, null);
        bloodTypeChoice = preferences.getString(PREFS_SAVE_USER_PROFILE_INFO_BLOOD_TYPE, null);
        lastDonation = preferences.getString(PREFS_SAVE_USER_PROFILE_INFO_LAST_DONATION, null);
        stateName = preferences.getString(PREFS_SAVE_USER_PROFILE_INFO_STATE, null);
        cityName = preferences.getString(PREFS_SAVE_USER_PROFILE_INFO_CITY, null);
        phone = preferences.getString(PREFS_SAVE_USER_PROFILE_INFO_PHONE, null);
    }

    private void setProfileClientDataToVariables(Client client) {
        name = client.getName();
        email = client.getEmail();
        dateOfBirth = client.getBirthDate();
        bloodTypeChoice = client.getBloodType().getName();
        lastDonation = client.getDonationLastDate();
        stateName = client.getBloodType().getName();
        cityName = client.getCity().getName();
        phone = client.getPhone();
        // pref------------------------------------------
        saveToPreference(name, email, dateOfBirth, bloodTypeChoice, lastDonation, stateName, cityName, phone);
        // ed--------------------------------------------
        setProfileDataToViews(name, email, dateOfBirth, bloodTypeChoice, lastDonation, stateName, cityName, phone);

    }

    private void setProfileDataToViews(String name, String email, String dateOfBirth, String bloodTypeChoice, String lastDonation, String stateName, String cityName, String phone) {
        nameET.setText(name);
        emailET.setText(email);
        dateOfBirthTV.setText(dateOfBirth);
        bloodTypeTV.setText(bloodTypeChoice);
        lastDonationDateTV.setText(lastDonation);
        stateTV.setText(stateName);
        cityTV.setText(cityName);
        phoneET.setText(phone);
    }

    private void saveToPreference(String name, String email, String dateOfBirth, String bloodTypeChoice, String lastDonation, String stateName, String cityName, String phone) {
        editor.putString(PREFS_SAVE_USER_PROFILE_INFO_USER_NAME, name);
        editor.putString(PREFS_SAVE_USER_PROFILE_INFO_USER_EMAIL, email);
        editor.putString(PREFS_SAVE_USER_PROFILE_INFO_DATE_OF_BIRTH, dateOfBirth);
        editor.putString(PREFS_SAVE_USER_PROFILE_INFO_BLOOD_TYPE, bloodTypeChoice);
        editor.putString(PREFS_SAVE_USER_PROFILE_INFO_LAST_DONATION, lastDonation);
        editor.putString(PREFS_SAVE_USER_PROFILE_INFO_STATE, stateName);
        editor.putString(PREFS_SAVE_USER_PROFILE_INFO_CITY, cityName);
        editor.putString(PREFS_SAVE_USER_PROFILE_INFO_PHONE, phone);
        editor.apply();
    }

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }
}
