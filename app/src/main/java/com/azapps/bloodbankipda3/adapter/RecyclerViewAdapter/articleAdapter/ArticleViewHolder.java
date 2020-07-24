package com.azapps.bloodbankipda3.adapter.RecyclerViewAdapter.articleAdapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azapps.bloodbankipda3.R;

public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView articleBackgroundImg, articleFavouriteImg;
    TextView articleTitleTV;
    OnArticleClickListener clickListener;

    public ArticleViewHolder(@NonNull View itemView, OnArticleClickListener onArticleClickListener) {
        super(itemView);
        articleBackgroundImg = itemView.findViewById(R.id.article_item_img_background_image);
        articleFavouriteImg = itemView.findViewById(R.id.article_item_img_add_to_favourite);
        articleTitleTV = itemView.findViewById(R.id.article_item_tv_title);

        itemView.setOnClickListener(this);
        clickListener = onArticleClickListener;
    }

    @Override
    public void onClick(View v) {
        clickListener.onArticleClick(getAdapterPosition());
    }
}
