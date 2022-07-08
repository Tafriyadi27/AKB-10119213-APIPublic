package com.skullbreraker.implementapi.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//    Tanggal Pengerjaan : 5 - 14 Juli 2022
//    NIM : 10119213
//    Nama : Tri Tafriyadi
//    Kelas : IF6

public class FreeGameModel {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("short_description")
    @Expose
    private String shortDescription;
    @SerializedName("game_url")
    @Expose
    private String gameUrl;
    @SerializedName("platform")
    private String platform;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }


    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

}

