package com.azapps.bloodbankipda3.adapter.RecyclerViewAdapter.articleAdapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.data.Article;
import com.bumptech.glide.Glide;

public class ArticleAdapter extends ListAdapter<Article, ArticleViewHolder> {
    private Context context;
    private OnArticleClickListener listener;
    private static final DiffUtilArticleCallBack CALL_BACK = new DiffUtilArticleCallBack();

    public ArticleAdapter(Context context, OnArticleClickListener clickListener) {
        super(CALL_BACK);
        this.context = context;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item, parent, false);
        return new ArticleViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article currentArticle = getItem(position);
        Uri image_uri = Uri.parse(currentArticle.getThumbnailFullPath());
        Glide.with(context).load(image_uri).into(holder.articleBackgroundImg);

        holder.articleTitleTV.setText(currentArticle.getTitle());
        if (currentArticle.getIsFavourite()) {
            holder.articleFavouriteImg.setImageResource(R.drawable.ic_favorite_filled);
        } else {
            holder.articleFavouriteImg.setImageResource(R.drawable.ic_favorite_border);
        }
    }
}
