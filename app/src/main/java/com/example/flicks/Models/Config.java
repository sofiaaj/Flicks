package com.example.flicks.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Config {
    String imageBaseUrl;
    String posterSize;
    String backdropSize;

    // Accesses the movie JSON object to get the necessary parameters to get the image url

    public Config(JSONObject object) throws JSONException {
        JSONObject images = object.getJSONObject("images");
        imageBaseUrl = images.getString("secure_base_url");
        JSONArray posterSizeOptions = images.getJSONArray("poster_sizes");
        JSONArray backdropSizeOptions = images.getJSONArray("backdrop_sizes");
        posterSize = posterSizeOptions.optString(3, "w342");
        backdropSize = backdropSizeOptions.optString(1, "w780");
    }

    public String getImageUrl(String size, String path){
        return String.format("%s%s%s", imageBaseUrl, size, path);
    }

    public String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public String getPosterSize() {
        return posterSize;
    }

    public String getBackdropSize() { return backdropSize; }
}
