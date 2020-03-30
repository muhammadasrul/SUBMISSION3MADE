package com.acun.submission3.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.acun.submission3.R;
import com.acun.submission3.models.TvShow;
import com.bumptech.glide.Glide;

public class TvShowDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TVSHOW = "extra_tvshow";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show_detail);

        TextView tvTitle = findViewById(R.id.txt_tvshow_title_detail);
        TextView tvRelease = findViewById(R.id.txt_tvshow_release_detail);
        TextView tvScore = findViewById(R.id.txt_tvshow_userscore_detail);
        TextView tvPopularity = findViewById(R.id.txt_tvshow_popularity_detail);
        TextView tvLanguage = findViewById(R.id.txt_tvshow_language);
        TextView tvOverview = findViewById(R.id.txt_tvshow_overview);
        ImageView imgPoster = findViewById(R.id.img_tvshow_detail);

        ProgressBar progressBar = findViewById(R.id.td_progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TVSHOW);

        String tvshow_detail = String.format(getResources().getString(R.string.tv_show_detail));
        setTitle(tvshow_detail);
        tvTitle.setText(tvShow.getTitle());
        tvRelease.setText(tvShow.getRelease());
        tvScore.setText(tvShow.getScore()+"/10");
        tvPopularity.setText(tvShow.getPopularity());
        tvLanguage.setText(tvShow.getLanguage());
        tvOverview.setText(tvShow.getOverview());

        Glide.with(TvShowDetailActivity.this)
                .load(tvShow.getPoster())
                .placeholder(R.color.colorAccent)
                .dontAnimate()
                .into(imgPoster);

        progressBar.setVisibility(View.GONE);
    }
}
