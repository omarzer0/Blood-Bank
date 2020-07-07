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

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.view.activity.MainActivity;
import com.azapps.bloodbankipda3.view.fragment.BaseFragment;

public class SliderFragment extends BaseFragment {

    private String[] stringArrayList = new String[]{"hi", "omar"};
    private Integer[] idArrayList = new Integer[]{R.drawable.slide_one_image, R.drawable.slide_two_image};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_slide_fragment, container, false);
        TextView sliderText = view.findViewById(R.id.item_slide_tv_text);
        ImageView sliderImage = view.findViewById(R.id.item_slide_img_image);
        TextView skipButton = view.findViewById(R.id.item_slide_tv_skip);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity.class));
//                getActivity().finish();
            }
        });


        int position = getArguments().getInt("position");
        if (position == 0) {
            skipButton.setVisibility(View.INVISIBLE);
        } else {
            skipButton.setVisibility(View.VISIBLE);
        }
        sliderText.setText(stringArrayList[position]);
        sliderImage.setImageResource(idArrayList[position]);
        return view;
    }

    @Override
    public void onBackFragment() {

    }
}
