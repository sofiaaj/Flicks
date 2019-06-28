package com.example.flicks;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.flicks.Models.Config;

public class MovieDetails extends Activity {

    TextView tvTitle2;
    TextView tvOverview2;
    ImageView ivBackdropImage;
    Config config;

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        tvTitle2.setText(getIntent().getStringExtra("Title"));
        tvOverview2 = (TextView) findViewById(R.id.tvOverview2);
        tvOverview2.setText(getIntent().getStringExtra("Overview"));
    }
}
