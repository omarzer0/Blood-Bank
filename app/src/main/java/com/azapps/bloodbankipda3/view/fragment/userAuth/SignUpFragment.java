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

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.azapps.bloodbankipda3.R;

import java.util.Calendar;

public class SignUpFragment extends Fragment implements View.OnClickListener {
    // ui
    private TextView dateOfBirthTV, bloodTypeTV, lastDonationDateTV;
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    // vars
    private String dateOfDateBirthShownOnTV = null;
    private String dateOfLastDonationShownOnTV = null;

    private int yearOfText, monthOfText, dayOfText;
    private int bloodTypeCheckedItem = -1;
    private String bloodTypeChoice;
    // arr
    private int[] dateOfBirthDateArray = new int[3];
    private int[] lastDonationDateArray = new int[3];
    private final String[] bloodTypeList = new String[]{"A+", "O+", "B+", "AB+", "A-", "O-", "B-", "AB-"};

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
                dateOfDateBirthShownOnTV = datePickerInit(dateOfBirthDateArray,dateOfDateBirthShownOnTV,dateOfBirthTV);
                break;

            case R.id.fragment_sign_up_tv_text_view_blood_type_choice:
                bloodTypeAlertDialog();
                break;

            case R.id.fragment_sign_up_tv_text_view_last_blood_donation:
                dateOfLastDonationShownOnTV = datePickerInit(lastDonationDateArray,dateOfDateBirthShownOnTV,lastDonationDateTV);
                break;
        }
    }

    private void bloodTypeAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle);
        builder.setTitle("Choose your blood type");
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

    private String datePickerInit(final int[] array, final String date, final TextView showDateTV) {
        final String[] s = {null};
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            array[0] = calendar.get(Calendar.YEAR);
            array[1] = calendar.get(Calendar.MONTH);
            array[2] = calendar.get(Calendar.DAY_OF_MONTH);
        }
        DatePickerDialog dialog = new DatePickerDialog(getActivity(),
                R.style.MyDatePickerStyle,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        array[0] = year;
                        array[1] = month;
                        array[2] = dayOfMonth;

                        s[0] = (month + 1) + "/" + dayOfMonth + "/" + year;
                        showDateTV.setText(s[0]);
                    }
                },
                array[0], array[1], array[2]);
        dialog.show();
        return dateOfDateBirthShownOnTV = s[0];
    }

}
