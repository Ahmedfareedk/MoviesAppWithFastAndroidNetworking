
package com.example.workingwithapis.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;



public class Trailers {

    @SerializedName("id")
    private Long mId;
    @SerializedName("results")
    private List<TrailerResult> mTrailerResults;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<TrailerResult> getResults() {
        return mTrailerResults;

    }

    public void setResults(List<TrailerResult> trailerResults) {
        mTrailerResults = trailerResults;
    }

}
