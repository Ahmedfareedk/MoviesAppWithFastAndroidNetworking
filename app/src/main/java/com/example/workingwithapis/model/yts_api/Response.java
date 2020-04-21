
package com.example.workingwithapis.model.yts_api;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Response {

    @SerializedName("data")
    private Data mData;
    @SerializedName("@meta")
    private Meta mMeta;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("status_message")
    private String mStatusMessage;

    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }

    public Meta getMeta() {
        return mMeta;
    }

    public void setMeta(Meta meta) {
        mMeta = meta;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getStatusMessage() {
        return mStatusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        mStatusMessage = statusMessage;
    }

}
