package com.rtukpe.fixtures.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

class LeagueTable {

    @SerializedName("leagueCaption")
    var league: String? = null

    @SerializedName("matchday")
    var matchday: Int = 0

    @SerializedName("standing")
    var standing: ArrayList<Standing>? = null

    inner class Standing {

        @SerializedName("rank")
        var rank: Int = 0

        @SerializedName("team")
        var team: String? = null

        @SerializedName("teamId")
        var id: Int = 0

        @SerializedName("playedGames")
        var playedGames: Int = 0

        @SerializedName("crestURI")
        var logo: String? = null

        @SerializedName("points")
        var points: Int = 0

        @SerializedName("goals")
        var goals: Int = 0

        @SerializedName("goalsAgainst")
        var goalsAgainst: Int = 0

        @SerializedName("goalDifference")
        var goalDifference: Int = 0
    }
}
