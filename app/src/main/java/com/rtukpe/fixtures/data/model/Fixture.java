package com.rtukpe.fixtures.data.model;

import java.util.Date;

import javax.annotation.Nullable;

public class Fixture {
    public int id;
    public int competitionId;
    public Date date;
    public String status;
    public int matchday;
    public String homeTeamName;
    public int homeTeamId;
    public String awayTeamName;
    public int awayTeamId;
    public Result result;

    public class Result {
        public int goalsHomeTeam = -1;
        public int goalsAwayTeam = -1;
        @Nullable
        HalfTime halfTime;
    }

    public class HalfTime {
        public int goalsHomeTeam = -1;
        public int goalsAwayTeam = -1;
    }
}
