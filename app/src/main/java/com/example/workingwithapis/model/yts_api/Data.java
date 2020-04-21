
package com.example.workingwithapis.model.yts_api;

import java.util.List;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Data {

    @SerializedName("limit")
    private Long mLimit;
    @SerializedName("movie_count")
    private Long mMovieCount;
    @SerializedName("movies")
    private List<MovieModel> mMovies;
    @SerializedName("page_number")
    private Long mPageNumber;

    public Long getLimit() {
        return mLimit;
    }

    public void setLimit(Long limit) {
        mLimit = limit;
    }

    public Long getMovieCount() {
        return mMovieCount;
    }

    public void setMovieCount(Long movieCount) {
        mMovieCount = movieCount;
    }

    public List<MovieModel> getMovies() {
        return mMovies;
    }

    public void setMovies(List<MovieModel> movies) {
        mMovies = movies;
    }

    public Long getPageNumber() {
        return mPageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        mPageNumber = pageNumber;
    }

}
