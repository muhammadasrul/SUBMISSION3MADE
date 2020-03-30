package com.acun.submission3.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.acun.submission3.R;
import com.acun.submission3.models.Movie;
import com.bumptech.glide.Glide;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        TextView tvTitle = findViewById(R.id.txt_movie_title_detail);
        TextView tvRelease = findViewById(R.id.txt_movie_release_detail);
        TextView tvPopularity = findViewById(R.id.txt_movie_popularity_detail);
        TextView tvUserscore = findViewById(R.id.txt_movie_userscore_detail);
        TextView tvLanguage = findViewById(R.id.txt_movie_language);
        TextView tvOverview = findViewById(R.id.txt_movie_overview);
        ImageView imgPoster = findViewById(R.id.img_movie_detail);

        ProgressBar progressBar = findViewById(R.id.md_progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        String movieDetail = String.format(getResources().getString(R.string.movie_detail));
        setTitle(movieDetail);
        tvTitle.setText(movie.getTitle());
        tvRelease.setText(movie.getRelease());
        tvPopularity.setText(movie.getPopularity());
        tvUserscore.setText(movie.getScore()+"/10");
        tvLanguage.setText(movie.getLanguage());
        tvOverview.setText(movie.getOverview());
        Glide.with(MovieDetailActivity.this)
                .load(movie.getPoster())
                .placeholder(R.color.colorAccent)
                .dontAnimate()
                .into(imgPoster);
        progressBar.setVisibility(View.GONE);

    }
}
