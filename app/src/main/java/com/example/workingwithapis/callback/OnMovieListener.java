package com.example.workingwithapis.callback;

import com.example.workingwithapis.model.Movies;

public interface OnMovieListener {
    void onResponse(Movies response);
    void onError(String error);
}
