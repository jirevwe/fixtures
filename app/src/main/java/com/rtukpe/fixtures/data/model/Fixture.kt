package com.rtukpe.fixtures.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

class Fixture {
    @SerializedName("id")
    @JvmField
    var id: Int = 0

    @SerializedName("competitionId")
    @JvmField
    var competitionId: Int = 0

    @SerializedName("date")
    var date: Date? = null

    @SerializedName("status")
    lateinit var status: String

    @SerializedName("matchday")
    @JvmField
    var matchday: Int = 0

    @SerializedName("homeTeamName")
    lateinit var homeTeamName: String

    @SerializedName("homeTeamId")
    @JvmField
    var homeTeamId: Int = 0

    @SerializedName("awayTeamName")
    lateinit var awayTeamName: String

    @SerializedName("awayTeamId")
    @JvmField
    var awayTeamId: Int = 0

    @SerializedName("result")
    lateinit var result: Result

    inner class Result {
        @SerializedName("goalsHomeTeam")
        @JvmField
        var goalsHomeTeam: Int = -1

        @SerializedName("goalsAwayTeam")
        @JvmField
        var goalsAwayTeam: Int = -1

        internal var halfTime: HalfTime? = null
    }

    inner class HalfTime {
        @SerializedName("goalsHomeTeam")
        @JvmField
        var goalsHomeTeam: Int = -1

        @SerializedName("goalsAwayTeam")
        @JvmField
        var goalsAwayTeam: Int = -1
    }
}
