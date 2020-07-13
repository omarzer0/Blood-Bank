package com.azapps.bloodbankipda3.view.fragment.userAuth;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.data.CalenderSaver;
import com.azapps.bloodbankipda3.helper.Utils;

import java.util.Calendar;

import static com.azapps.bloodbankipda3.helper.Constant.bloodTypeList;

public class SignUpFragment extends Fragment implements View.OnClickListener {
    // ui
    private TextView dateOfBirthTV, bloodTypeTV, lastDonationDateTV;
    // vars
    private CalenderSaver calenderSaverForDateOfBirth = null;
    private CalenderSaver calenderSaverForLastDonation = null;

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
        dateOfBirthTV.setOnClickListener(this);
        bloodTypeTV.setOnClickListener(this);
        lastDonationDateTV.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_sign_up_tv_text_view_date_of_birth:
                calenderSaverForDateOfBirth = Utils.showCalender(calenderSaverForDateOfBirth,dateOfBirthTV,getActivity());
                break;

            case R.id.fragment_sign_up_tv_text_view_blood_type_choice:
                bloodTypeAlertDialog("Choose your blood type");
                break;

            case R.id.fragment_sign_up_tv_text_view_last_blood_donation:
                calenderSaverForLastDonation = Utils.showCalender(calenderSaverForLastDonation,lastDonationDateTV,getActivity());
                break;
        }
    }

    private void bloodTypeAlertDialog(String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle);
        builder.setTitle(title);
        builder.setSingleChoiceItems(bloodTypeList, bloodTypeCheckedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bloodTypeCheckedItem = which;
                bloodTypeChoice = bloodTypeList[which];
                bloodTypeTV.setText(bloodTypeChoice);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

}
