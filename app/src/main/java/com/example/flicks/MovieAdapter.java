package com.example.flicks;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flicks.Models.Config;
import com.example.flicks.Models.Movie;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    ArrayList<Movie> movies;


    Config config;

    Context context;

    private ViewHolder.onMovieListener onMovieListener;

    public MovieAdapter(ArrayList<Movie> movies, ViewHolder.onMovieListener onMovieListener) {
        this.movies = movies;
        this.onMovieListener = onMovieListener;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }






    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View movieView = inflater.inflate(R.layout.item_movie, parent, false);


        return new ViewHolder(movieView, onMovieListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        int radius = 20;
        int margin = 10;
        boolean isPortrait = context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
        holder.tvTitle.setText(movie.getTitle());
        holder.tvOverview.setText(movie.getOverview());
        holder.tvOverview.setMovementMethod(new ScrollingMovementMethod());
        String imageUrl = isPortrait ? config.getImageUrl(config.getPosterSize(), movie.getPosterPath()) : config.getImageUrl(config.getBackdropSize(), movie.getBackdropPath());
        int placeHolderId = isPortrait ? R.drawable.flicks_movie_placeholder : R.drawable.flicks_backdrop_placeholder;
        ImageView imageView = isPortrait ? holder.ivPosterImage : holder.ivBackdropImage;
        Glide.with(context)
                .load(imageUrl)
                .placeholder(placeHolderId)
                .error(placeHolderId)
                .bitmapTransform(new RoundedCornersTransformation(context, radius, margin))
                .into(imageView);


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView ivPosterImage;
        ImageView ivBackdropImage;
        TextView tvTitle;
        TextView tvOverview;
        onMovieListener onMovieListener;

        public ViewHolder(@NonNull View itemView, onMovieListener onMovieListener) {
            super(itemView);
            ivPosterImage = (ImageView) itemView.findViewById(R.id.ivPosterImage);
            ivBackdropImage = (ImageView) itemView.findViewById(R.id.ivBackdropImage);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle2);
            tvOverview = (TextView) itemView.findViewById(R.id.tvOverview2);
            this.onMovieListener = onMovieListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onMovieListener.onMovieClick(getAdapterPosition());

        }

        public interface onMovieListener{
            void onMovieClick(int position);
        }
    }
}
