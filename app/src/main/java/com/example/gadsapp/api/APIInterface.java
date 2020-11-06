package com.example.gadsapp.api;

import com.example.gadsapp.model.SkillIQModelData;
import com.example.gadsapp.model.LearningLeadersModelData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface  {


    @GET("/api/hours")
    Call<List<LearningLeadersModelData>> getLearningLeaders();

    @GET("/api/skilliq")
    Call<List<SkillIQModelData>> getSkillIqLeaders();
}
