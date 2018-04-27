package com.rtukpe.fixtures.data.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("shortName")
    public String shortName;
    @SerializedName("crestUrl")
    public String logo;
}
