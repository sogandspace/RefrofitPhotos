package com.example.refrofitphotos.model;

import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("id")
    private int mId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("url")
    private String mUrl;

    @SerializedName("thumbnailUrl")
    private String mThumbnailUrl;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getThumbnailUrl() {
        return mThumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        mThumbnailUrl = thumbnailUrl;
    }

    public Photo( int id, String title, String url, String thumbnailUrl) {
        mId = id;
        mTitle = title;
        mUrl = url;
        mThumbnailUrl = thumbnailUrl;
    }
}