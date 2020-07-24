package com.azapps.bloodbankipda3.adapter.RecyclerViewAdapter.articleAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.azapps.bloodbankipda3.data.Article;

public class DiffUtilArticleCallBack extends DiffUtil.ItemCallback<Article> {
    @Override
    public boolean areItemsTheSame(@NonNull Article oldItem, @NonNull Article newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Article oldItem, @NonNull Article newItem) {
        return oldItem.getTitle().equals(newItem.getTitle())
                && oldItem.getThumbnailFullPath().equals(newItem.getThumbnailFullPath());
    }
}
