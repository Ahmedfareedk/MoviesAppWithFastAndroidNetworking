package com.example.workingwithapis.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.workingwithapis.Contract.Constants;
import com.example.workingwithapis.callback.OnMovieListener;
import com.example.workingwithapis.callback.OnTrailerListener;
import com.example.workingwithapis.model.Movies;
import com.example.workingwithapis.model.Trailers;


public class Networking {

    public static void fetchMovies(final OnMovieListener listener)
    {

        AndroidNetworking.get("https://api.themoviedb.org/3/trending/{media_type}/{time_window}")
                .addPathParameter("media_type", "movie")
                .addPathParameter("time_window", "week")
                .addQueryParameter("api_key", Constants.ApiKey.apiKey)
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

    public static void fetchTrailers(String movieId, final OnTrailerListener listener)
    {
        AndroidNetworking.get("https://api.themoviedb.org/3/movie/{movie_id}/videos")
                .addQueryParameter("api_key", Constants.ApiKey.apiKey)
                .addPathParameter("movie_id", movieId)
                .build()
                .getAsObject(Trailers.class, new ParsedRequestListener<Trailers>() {

                    @Override
                    public void onResponse(Trailers response) {
                        listener.onResponse(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        listener.onError(anError.getErrorDetail());
                    }
                });
    }

   /* public static void fetch(String movieId, String request,final OnMovieListener listener)
    {
        AndroidNetworking.get("https://api.themoviedb.org/3/movie/{movie_id}/{request}")
                .addQueryParameter("api_key", Constants.ApiKey.apiKey)
                .addPathParameter("movie_id", movieId)
                .addPathParameter("request", request)
                .build()
                .getAsObject(Trailers.class, new ParsedRequestListener<Trailers>() {

                    @Override
                    public void onResponse(Trailers response) {
                        listener.onResponse(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        listener.onError(anError.getErrorDetail());
                    }
                });
    }*/

    public static <E> void fetchResponses(String movieId, String request, Class<E> mapClass, final OnMovieListener listener)
    {
        AndroidNetworking.get("https://api.themoviedb.org/3/movie/{movie_id}/{request}")
                .addQueryParameter("api_key", Constants.ApiKey.apiKey)
                .addPathParameter("movie_id", movieId)
                .addPathParameter("request", request)
                .build()
                .getAsObject(mapClass, new ParsedRequestListener<E>() {
                    @Override
                    public void onResponse(E response) {
                        listener.onResponse(response);

                    }

                    @Override
                    public void onError(ANError anError) {
                        listener.onError(anError.getErrorDetail());
                    }
                });
    }
}
