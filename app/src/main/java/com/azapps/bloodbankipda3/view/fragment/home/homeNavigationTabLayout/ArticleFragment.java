package com.azapps.bloodbankipda3.view.fragment.home.homeNavigationTabLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azapps.bloodbankipda3.R;
import com.azapps.bloodbankipda3.adapter.RecyclerViewAdapter.articleAdapter.ArticleAdapter;
import com.azapps.bloodbankipda3.adapter.RecyclerViewAdapter.articleAdapter.OnArticleClickListener;
import com.azapps.bloodbankipda3.data.Article;
import com.azapps.bloodbankipda3.data.RetrofitArticleDataStatus;
import com.azapps.bloodbankipda3.helper.Utils;
import com.azapps.bloodbankipda3.helper.retrofitCalls.DataApi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;
import static com.azapps.bloodbankipda3.helper.Constant.PREFS_LOGIN_FILE_NAME;
import static com.azapps.bloodbankipda3.helper.Constant.PREF_API_TOKEN;

public class ArticleFragment extends Fragment implements OnArticleClickListener {
    //vars
    private int page = 1;
    private List<Article> articles;
    private RecyclerView recyclerView;
    private View.OnClickListener onAddArticleFabListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_article, container, false);
        recyclerView = view.findViewById(R.id.fragment_tab_article_recycler_view);
        FloatingActionButton addArticleFab = view.findViewById(R.id.fragment_rab_article_add_article_fab);
        addArticleFab.setOnClickListener(onAddArticleFabListener);

        SharedPreferences loginFileSharedPreference = getContext().getSharedPreferences(PREFS_LOGIN_FILE_NAME, MODE_PRIVATE);
        String api_token = loginFileSharedPreference.getString(PREF_API_TOKEN, null);
        if (api_token != null) {
            requestArticleDataFromRetrofit(api_token, page);
        }

        return view;
    }

    private void requestArticleDataFromRetrofit(String api_token, int page) {
        DataApi dataApi = Utils.createRetrofit();
        Call<RetrofitArticleDataStatus> call = dataApi.getUserArticleData(api_token, page);
        call.enqueue(new Callback<RetrofitArticleDataStatus>() {
            @Override
            public void onResponse(Call<RetrofitArticleDataStatus> call, Response<RetrofitArticleDataStatus> response) {
                if (!response.isSuccessful()) {
                    // Server error
                    Toast.makeText(getActivity(), "failed to connect to the server", Toast.LENGTH_SHORT).show();
                } else {
                    // successfully fetched data>>> check status if it is right
                    checkForArticleComingDataStatus(response.body());
                }
            }

            @Override
            public void onFailure(Call<RetrofitArticleDataStatus> call, Throwable t) {
                Toast.makeText(getActivity(), "check your network connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkForArticleComingDataStatus(RetrofitArticleDataStatus body) {
        int status = body.getStatus();
        String msg = body.getMsg();
        if (status == 0) {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        } else if (status == 1) {
            List<Article> articles = body.getArticleData().getData();
            buildArticleRecyclerView(articles);
        }
    }

    private void buildArticleRecyclerView(List<Article> articleList) {
        articles = articleList;
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.hasFixedSize();
        ArticleAdapter adapter = new ArticleAdapter(getContext(), this);
        adapter.submitList(articles);
        recyclerView.setAdapter(adapter);
    }

    public static ArticleFragment newInstance() {
        return new ArticleFragment();
    }

    @Override
    public void onArticleClick(int position) {
        Toast.makeText(getActivity(), articles.get(position).getTitle(), Toast.LENGTH_SHORT).show();
    }
}
