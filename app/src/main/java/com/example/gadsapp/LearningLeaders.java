package com.example.gadsapp;

public class LearningLeaders {
    private String Name;
    private String Hours;
    private String Country;

    public LearningLeaders() {
    }
    public LearningLeaders( String learning_name, String learning_hours, String learning_country ){
        Name = learning_name;
        Hours = learning_hours;
        Country = learning_country;
    }
    // Getters

    public String getName() {
        return Name;
    }

    public String getHours() {
        return Hours;
    }

    public String getCountry() {
        return Country;
    }
    // Setters

    public void setName(String name) {
        Name = name;
    }

    public void setHours(String hours) {
        Hours = hours;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
