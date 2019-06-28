package com.example.flicks.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class Movie {
    private String title;
    private String overview;
    private String posterPath;
    private String backdropPath;
    private String id;
    private String review;
    private Double voteAverage;


// Gets information from the JSON object and feeds it into the different fields so that information
// can be gotten from the movie class

    public Movie(JSONObject object) throws JSONException {
        title = object.getString("title");
        overview = object.getString("overview");
        posterPath = object.getString("poster_path");
        backdropPath = object.getString("backdrop_path");
        id = object.getString("id");
        voteAverage = object.getDouble("vote_average");



    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() { return backdropPath; }

    public String getId(){return id; }

    public void putReview(String newReview){
        review = newReview;
    }

    public String getReview(){ return review; }

    public Double getVoteAverage() {
        return voteAverage;
    }
}
