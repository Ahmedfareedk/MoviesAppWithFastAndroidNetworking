package com.example.workingwithapis.callback;

import com.example.workingwithapis.model.Trailers;

public interface OnTrailerListener {
    void onResponse(Trailers response);
    void onError(String error);
}
