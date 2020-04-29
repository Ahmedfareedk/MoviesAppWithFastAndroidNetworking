package com.example.workingwithapis.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.workingwithapis.callback.OnMovieListener;
import com.example.workingwithapis.model.Movies;


public class Networking {

    public static void fetchMovies(final OnMovieListener listener)
    {

        AndroidNetworking.get("https://api.themoviedb.org/3/trending/{media_type}/{time_window}")
                .addPathParameter("media_type", "movie")
                .addPathParameter("time_window", "week")
                .addQueryParameter("api_key", "9340a47ece52c04bb89b417830b3f601")

                .build()
                .getAsObject(Movies.class, new ParsedRequestListener<Movies>() {
                    @Override
                    public void onResponse(Movies response) {
                        listener.onResponse(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        listener.onError(anError.getErrorDetail());
                    }
                });

    }
}
