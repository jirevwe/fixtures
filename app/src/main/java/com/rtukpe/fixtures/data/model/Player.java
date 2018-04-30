package com.rtukpe.fixtures.data.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Player {

    public int id;
    public String name;
    public String position;
    @SerializedName("jerseyNumber")
    public int jerseyNumber;
    @SerializedName("dateOfBirth")
    public String dateOfBirth;
    public String nationality;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
