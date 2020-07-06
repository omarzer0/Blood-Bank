package com.azapps.bloodbankipda3.view.fragment;

import androidx.fragment.app.Fragment;

import com.azapps.bloodbankipda3.view.activity.BaseActivity;

public class BaseFragment extends Fragment {
    public BaseActivity baseActivity;

    public void initFragment(){
        baseActivity = (BaseActivity) getActivity();
    }

    public void onBackFragment(){

    }
}
