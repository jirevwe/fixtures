package com.rtukpe.fixtures.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LeagueTable {

    @SerializedName("leagueCaption")
    public String league;

    @SerializedName("matchday")
    public int matchday;

    @SerializedName("standing")
    public ArrayList<Standing> standing;

    public class Standing {

        @SerializedName("rank")
        public int rank;

        @SerializedName("team")
        public String team;

        @SerializedName("teamId")
        public int id;

        @SerializedName("playedGames")
        public int playedGames;

        @SerializedName("crestURI")
        public String logo;

        @SerializedName("points")
        public int points;

        @SerializedName("goals")
        public int goals;

        @SerializedName("goalsAgainst")
        public int goalsAgainst;

        @SerializedName("goalDifference")
        public int goalDifference;
    }
}
