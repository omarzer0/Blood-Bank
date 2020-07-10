package com.azapps.bloodbankipda3.view.fragment.slider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.view.activity.userAuth.LoginActivity;

public class SliderFragment extends Fragment {

    private String[] stringArrayList = new String[]{"hi", "omar"};
    private Integer[] idArrayList = new Integer[]{R.drawable.slide_one_image, R.drawable.slide_two_image};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_slide_fragment, container, false);
        TextView sliderText = view.findViewById(R.id.item_slide_tv_text);
        ImageView sliderImage = view.findViewById(R.id.item_slide_img_image);

        int position = getArguments().getInt("position");
        sliderText.setText(stringArrayList[position]);
        sliderImage.setImageResource(idArrayList[position]);
        return view;
    }
}
