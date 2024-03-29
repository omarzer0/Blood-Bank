package com.azapps.bloodbankipda3.helper;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.data.CalenderSaver;

import java.util.Calendar;


public class Utils {

    public static void replaceFragments(Fragment fragment, FragmentManager fragmentManager, int container) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(container, fragment)
                .addToBackStack(null)
                .commit();
    }

    public static void replaceFragmentsWithoutBackStack(Fragment fragment, FragmentManager fragmentManager, int container) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(container, fragment)
                .commit();
    }

    public static CalenderSaver showCalender(CalenderSaver saver, final TextView textView, final Activity activity){
        final CalenderSaver returnSaver = new CalenderSaver(0,0,0);
        Calendar calendar = Calendar.getInstance();
        final int[] arr = new int[3];
        if (saver == null){
            arr[0] = calendar.get(Calendar.YEAR);
            arr[1] = calendar.get(Calendar.MONTH);
            arr[2] = calendar.get(Calendar.DAY_OF_MONTH);
        }else{
            arr[0] = saver.getYear();
            arr[1] = saver.getMonth()-1;
            arr[2] = saver.getDay();
        }

        DatePickerDialog dialog = new DatePickerDialog(activity,
                R.style.MyDatePickerStyle,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date = (month + 1) + "/" + dayOfMonth + "/" + year;
                        textView.setText(date);
                        returnSaver.setYear(year);
                        returnSaver.setMonth(month+1);
                        returnSaver.setDay(dayOfMonth);
                    }
                }, arr[0], arr[1], arr[2]);

        dialog.show();
        return returnSaver;
    }

}
