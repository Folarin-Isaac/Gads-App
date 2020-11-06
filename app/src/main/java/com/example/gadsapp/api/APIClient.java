package com.example.gadsapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static Retrofit retrofitLeaderBoard;
    // Defines Base Url
    public static final String baseUrl = "https://gadsapi.herokuapp.com";

    // create Retrofit Instance
    public static Retrofit getApiClient(){
        if (retrofitLeaderBoard == null){
            retrofitLeaderBoard = new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofitLeaderBoard;
    }
}
