package com.example.workingwithapis.callback;

import com.example.workingwithapis.api.Movies;

public interface OnMovieListener {
    void onResponse(Movies response);
    void onError(String error);
}
