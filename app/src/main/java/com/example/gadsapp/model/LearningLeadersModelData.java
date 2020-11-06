package com.example.gadsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LearningLeadersModelData {
    @SerializedName("name")
    public String name;

    @SerializedName("hours")
    public int hours;

    @SerializedName("country")
    public String country;


    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }
}