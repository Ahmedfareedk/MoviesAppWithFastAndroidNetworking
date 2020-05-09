package com.example.workingwithapis.callback;

import com.example.workingwithapis.model.Movies;

public interface OnMovieListener<T> {
    void onResponse(T response);
    void onError(String error);
}
