package com.rtukpe.fixtures.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

class LeagueTable {

    @SerializedName("leagueCaption")
    lateinit var league: String

    @SerializedName("matchday")
    @JvmField
    var matchday: Int = 0

    @SerializedName("standing")
    lateinit var standing: ArrayList<Standing>

    inner class Standing {

        @SerializedName("rank")
        @JvmField
        var rank: Int = 0

        @SerializedName("team")
        var team: String? = null

        @SerializedName("teamId")
        @JvmField
        var id: Int = 0

        @SerializedName("playedGames")
        @JvmField
        var playedGames: Int = 0

        @SerializedName("crestURI")
        var logo: String? = ""

        @SerializedName("points")
        @JvmField
        var points: Int = 0

        @SerializedName("goals")
        @JvmField
        var goals: Int = 0

        @SerializedName("goalsAgainst")
        @JvmField
        var goalsAgainst: Int = 0

        @SerializedName("goalDifference")
        @JvmField
        var goalDifference: Int = 0
    }
}
