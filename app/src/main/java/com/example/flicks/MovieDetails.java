package com.example.flicks;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flicks.Models.Config;

public class MovieDetails extends Activity {

    TextView tvTitle2;
    TextView tvOverview2;
    ImageView ivBackdropImage;
    Config config;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        tvTitle2.setText(getIntent().getStringExtra("Title"));
        tvOverview2 = (TextView) findViewById(R.id.tvOverview2);
        tvOverview2.setText(getIntent().getStringExtra("Overview"));
        ivBackdropImage = (ImageView) findViewById(R.id.ivBackdropImage);
        int placeHolderId = R.drawable.flicks_backdrop_placeholder;
        Glide.with(getApplicationContext())
                .load(getIntent().getStringExtra("imgURL"))
                .placeholder(placeHolderId)
                .error(placeHolderId)
                .into(ivBackdropImage);
    }
}
