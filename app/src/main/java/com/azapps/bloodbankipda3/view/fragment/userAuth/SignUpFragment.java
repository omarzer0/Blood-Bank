package com.azapps.bloodbankipda3.view.fragment.userAuth;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.data.CalenderSaver;
import com.azapps.bloodbankipda3.data.RetrofitCallStatus;
import com.azapps.bloodbankipda3.data.SignUpUser;
import com.azapps.bloodbankipda3.helper.Utils;
import com.azapps.bloodbankipda3.helper.retrofitCalls.DataApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.azapps.bloodbankipda3.helper.Constant.bloodTypeList;

public class SignUpFragment extends Fragment implements View.OnClickListener {
    // ui
    private TextView dateOfBirthTV, bloodTypeTV, lastDonationDateTV, stateTV, cityTV;
    private EditText nameET, emailET, phoneET, newPasswordET, confirmNewPasswordET;
    // vars
    private CalenderSaver calenderSaverForDateOfBirth = null;
    private CalenderSaver calenderSaverForLastDonation = null;
    private String name, email, dateOfBirth, lastDonation, phone, newPassword, confirmNewPassword;
    private int state, city;

    private int bloodTypeCheckedItem = -1;
    private String bloodTypeChoice;

    public SignUpFragment() {
    }

    public static SignUpFragment newInstance() {
        return new SignUpFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        dateOfBirthTV = view.findViewById(R.id.fragment_sign_up_tv_text_view_date_of_birth);
        bloodTypeTV = view.findViewById(R.id.fragment_sign_up_tv_text_view_blood_type_choice);
        lastDonationDateTV = view.findViewById(R.id.fragment_sign_up_tv_text_view_last_blood_donation);

        stateTV = view.findViewById(R.id.fragment_sign_up_tv_text_view_state_location);
        cityTV = view.findViewById(R.id.fragment_sign_up_tv_text_view_city_location);

        nameET = view.findViewById(R.id.fragment_sign_up_ed_edit_text_name);
        emailET = view.findViewById(R.id.fragment_sign_up_ed_edit_text_email);
        phoneET = view.findViewById(R.id.fragment_sign_up_ed_edit_text_phone);
        newPasswordET = view.findViewById(R.id.fragment_sign_up_ed_edit_text_new_password);
        confirmNewPasswordET = view.findViewById(R.id.fragment_sign_up_ed_edit_test_confirm_new_password);

        Button signUpBtn = view.findViewById(R.id.fragment_sign_up_btn_button_sign_up);

        // click listeners
        dateOfBirthTV.setOnClickListener(this);
        bloodTypeTV.setOnClickListener(this);
        lastDonationDateTV.setOnClickListener(this);

        stateTV.setOnClickListener(this);
        cityTV.setOnClickListener(this);

        signUpBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_sign_up_tv_text_view_date_of_birth:
                calenderSaverForDateOfBirth = Utils.showCalender(calenderSaverForDateOfBirth, dateOfBirthTV, getActivity());
                break;

            case R.id.fragment_sign_up_tv_text_view_blood_type_choice:
                bloodTypeAlertDialog("Choose your blood type");
                break;

            case R.id.fragment_sign_up_tv_text_view_last_blood_donation:
                calenderSaverForLastDonation = Utils.showCalender(calenderSaverForLastDonation, lastDonationDateTV, getActivity());
                lastDonation = calenderSaverForLastDonation.getStDateOfBirth();
                break;
            case R.id.fragment_sign_up_btn_button_sign_up:
                boolean areInputsOk = checkForInputData();
                if (areInputsOk) {
                    signUpWithRetrofit();
                }
        }
    }

    private void signUpWithRetrofit() {
        DataApi dataApi = Utils.createRetrofit();
        SignUpUser signUpUser = new SignUpUser(name, email, dateOfBirth, bloodTypeCheckedItem, lastDonation, 1, phone, newPassword, confirmNewPassword);
        getUserSignUpResultsFromRetrofit(dataApi, signUpUser);
    }

    private void getUserSignUpResultsFromRetrofit(DataApi api, SignUpUser user) {
        Call<RetrofitCallStatus> call = api.getSignUpDataResponse(user);
        call.enqueue(new Callback<RetrofitCallStatus>() {
            @Override
            public void onResponse(Call<RetrofitCallStatus> call, Response<RetrofitCallStatus> response) {
                if (!response.isSuccessful()) {
                    // Server error
                    Toast.makeText(getActivity(), "failed to connect to the server", Toast.LENGTH_SHORT).show();
                } else {
                    // successfully fetched data>>> check status if it is right
                    String msg = response.body().getMsg();
                    int status = response.body().getStatus();
                    if (status == 0) {
                        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                    } else if (status == 1) {
                        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                        //TODO: try more useful way to do this
                        getFragmentManager().popBackStack();
                    } else {
                        Toast.makeText(getActivity(), "Un Expected Error", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<RetrofitCallStatus> call, Throwable t) {
                Toast.makeText(getActivity(), "check your network connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void bloodTypeAlertDialog(String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertDialogStyle);
        builder.setTitle(title);
        builder.setSingleChoiceItems(bloodTypeList, bloodTypeCheckedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bloodTypeCheckedItem = which + 1;
                bloodTypeChoice = bloodTypeList[which];
                bloodTypeTV.setText(bloodTypeChoice);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private boolean checkForInputData() {
        boolean isInputDataOk = true;
        name = nameET.getText().toString().trim();
        email = emailET.getText().toString().trim();
        phone = phoneET.getText().toString().trim();
        newPassword = newPasswordET.getText().toString().trim();
        confirmNewPassword = confirmNewPasswordET.getText().toString().trim();

        if (calenderSaverForDateOfBirth != null) {
            dateOfBirth = calenderSaverForDateOfBirth.getStDateOfBirth();
        } else {
            dateOfBirth = null;
        }

        if (calenderSaverForLastDonation != null) {
            lastDonation = calenderSaverForLastDonation.getStDateOfBirth();
        } else {
            lastDonation = null;
        }


        if (name.equals("") || name.isEmpty()) {
            nameET.setError("Please enter a name");
            isInputDataOk = false;
        }
        if (email.equals("") || name.isEmpty()) {
            emailET.setError("please enter an email");
            isInputDataOk = false;
        }
        if (dateOfBirth == null || dateOfBirth.isEmpty()) {
            isInputDataOk = false;
        }
        if (bloodTypeCheckedItem < 1 || bloodTypeCheckedItem > 8) {
            bloodTypeTV.setError("Please choose a blood type");
            isInputDataOk = false;
        }
        if (lastDonation == null || lastDonation.isEmpty()) {
            isInputDataOk = false;
        }
        if (phone == null || phone.isEmpty()) {
            phoneET.setError("please enter a number");
            isInputDataOk = false;
        }
        if (newPassword == null || newPassword.isEmpty()) {
            newPasswordET.setError("please enter a password");
            isInputDataOk = false;
        }
        if (confirmNewPassword == null || confirmNewPassword.isEmpty()) {
            confirmNewPasswordET.setError("please enter a confirm password");
            isInputDataOk = false;
        } else if (!confirmNewPassword.equals(newPassword)) {
            confirmNewPasswordET.setError("password and confirm password don't match");
            isInputDataOk = false;
        }
        return isInputDataOk;
    }

}
