package com.skullbreraker.implementapi.Api;

import com.skullbreraker.implementapi.Model.FreeGameModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @Headers(
            "X-RapidAPI-Host: free-to-play-games-database.p.rapidapi.com"
    )
    @GET("games")
    Call<List<FreeGameModel>> groupList(@Header ("X-RapidAPI-Key") String api_key,@Query("category") String category);
}
