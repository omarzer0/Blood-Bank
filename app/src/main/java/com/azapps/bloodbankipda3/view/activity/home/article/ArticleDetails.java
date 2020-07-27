package com.azapps.bloodbankipda3.view.activity.home.article;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.azapps.bloodbankipda3.R;
import com.bumptech.glide.Glide;

import static com.azapps.bloodbankipda3.helper.Constant.ARTICLE_BACKGROUND_IMAGE_EXTRA;
import static com.azapps.bloodbankipda3.helper.Constant.ARTICLE_BUNDLE_EXTRA;
import static com.azapps.bloodbankipda3.helper.Constant.ARTICLE_CONTENT_EXTRA;
import static com.azapps.bloodbankipda3.helper.Constant.ARTICLE_FAVOURITE_IMAGE_EXTRA;
import static com.azapps.bloodbankipda3.helper.Constant.ARTICLE_TITLE_EXTRA;

public class ArticleDetails extends AppCompatActivity {
    // ui
    ImageView detailsImageBackground, favouriteImageView;
    TextView titleTextView, contentTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_details);
        detailsImageBackground = findViewById(R.id.article_details_article_background_img_image_view);
        favouriteImageView = findViewById(R.id.article_details_article_favourite_img_image_view);
        titleTextView = findViewById(R.id.article_details_article_title_tv_text_view);
        contentTextView = findViewById(R.id.article_details_article_content_tv_text_view);

        if (getIntent().hasExtra(ARTICLE_BUNDLE_EXTRA)){
            Bundle bundle = getIntent().getBundleExtra(ARTICLE_BUNDLE_EXTRA);
            titleTextView.setText(bundle.getString(ARTICLE_TITLE_EXTRA));
            contentTextView.setText(bundle.getString(ARTICLE_CONTENT_EXTRA));
            Glide.with(this).load(bundle.getString(ARTICLE_BACKGROUND_IMAGE_EXTRA)).into(detailsImageBackground);
            if (bundle.getBoolean(ARTICLE_FAVOURITE_IMAGE_EXTRA)){
                favouriteImageView.setImageResource(R.drawable.ic_favorite_filled);
            }else {
                favouriteImageView.setImageResource(R.drawable.ic_favorite_border);
            }
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
}