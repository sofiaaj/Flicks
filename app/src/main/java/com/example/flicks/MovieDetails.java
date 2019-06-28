package com.example.flicks;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flicks.Models.Config;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MovieDetails extends Activity {

    TextView tvTitle2;
    TextView tvOverview2;
    ImageView ivBackdropImage;
    TextView tvReview;
    Config config;
    public final static String API_BASE_URL = "https://api.themoviedb.org/3";
    public final static String API_KEY_PARAM = "api_key";
    public final static String LANGUAGE = "language";
    public final static String PAGE = "page";
    AsyncHttpClient client;
    String review;


    public void getReviews(){
        client = new AsyncHttpClient();
        String url = API_BASE_URL + "/movie";
        String currentId = getIntent().getStringExtra("movieId");
        url += "/" + currentId + "/reviews";
        RequestParams params = new RequestParams();
        params.put(API_KEY_PARAM, getString(R.string.api_key));
        params.put(LANGUAGE, "en-US");
        params.put(PAGE, "1");
        client.get(url, params, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONArray results = response.getJSONArray("results");
                    review = results.getJSONObject(0).getString("content");
                    Log.i("Reviews", review);
                    setInfo();
                } catch (JSONException e) {
                    Log.i("Reviews", "Failed parsing reviews");
                }
            }

        });



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getReviews();
        setContentView(R.layout.activity_movie_details);

    }

    public void setInfo(){
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        tvTitle2.setText(getIntent().getStringExtra("Title"));
        tvOverview2 = (TextView) findViewById(R.id.tvOverview2);
        tvOverview2.setText(getIntent().getStringExtra("Overview"));
        ivBackdropImage = (ImageView) findViewById(R.id.ivBackdropImage);
        tvReview = (TextView) findViewById(R.id.tvReview);
        tvReview.setText(review);
        int placeHolderId = R.drawable.flicks_backdrop_placeholder;
        Glide.with(getApplicationContext())
                .load(getIntent().getStringExtra("imgURL"))
                .placeholder(placeHolderId)
                .error(placeHolderId)
                .into(ivBackdropImage);

    }
}
