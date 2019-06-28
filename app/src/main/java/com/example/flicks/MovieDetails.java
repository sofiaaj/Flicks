package com.example.flicks;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MovieDetails extends Activity {

    TextView tvTitle2;
    TextView tvOverview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        tvTitle2.setText(getIntent().getStringExtra("Title"));
        tvOverview2 = (TextView) findViewById(R.id.tvOverview2);
        tvOverview2.setText(getIntent().getStringExtra("Overview"));
//        String imageUrl = config.getImageUrl(config.getPosterSize(), movie.getPosterPath()) ;
//        int placeHolderId = isPortrait ? R.drawable.flicks_movie_placeholder : R.drawable.flicks_backdrop_placeholder;
//        ImageView imageView = isPortrait ? holder.ivPosterImage : holder.ivBackdropImage;
//        Glide.with(context)
//                .load(imageUrl)
//
//                .placeholder(placeHolderId)
//                .error(placeHolderId)
//                .bitmapTransform(new RoundedCornersTransformation(context, radius, margin))
//                .into(imageView);

    }
}
