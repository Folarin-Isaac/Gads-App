package com.example.gadsapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface  {


    @GET("/api/hours")
    Call<List<LearningLeadersModelData>> getLearningLeaders();
}
