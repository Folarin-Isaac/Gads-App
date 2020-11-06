package com.example.gadsapp.model;

import com.google.gson.annotations.SerializedName;

public class SkillIQModelData {

    @SerializedName("name")
    private String name;

    @SerializedName("score")
    private int score;

    @SerializedName("country")
    private String country;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getCountry() {
        return country;
    }
}
