package com.azapps.bloodbankipda3.view.fragment.home.homeNavigationTabLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.azapps.bloodbankipda3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ArticleFragment extends Fragment {
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_article, container, false);
        FloatingActionButton addArticleFab = view.findViewById(R.id.fragment_rab_article_add_article_fab);
        addArticleFab.setOnClickListener(onClickListener);
        return view;
    }

    public static ArticleFragment newInstance() {
        return new ArticleFragment();
    }
}
