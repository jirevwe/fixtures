package com.rtukpe.fixtures.data.repository.remote.api

import com.rtukpe.fixtures.data.model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

/**
 * Created by rtukpe on 22/03/2018.
 */

interface RemoteServiceApi {

    @get:Headers("X-Auth-Token: 7801836b9d924a48b2970153fe220b49", "X-Response-Control:minified")
    @get:GET("/v1/competitions")
    val competitions: Observable<ArrayList<Competition>>

    @Headers("X-Auth-Token: 7801836b9d924a48b2970153fe220b49", "X-Response-Control:minified")
    @GET("/v1/competitions/{id}/teams")
    fun getCompetitionTeams(@Path("id") id: Int): Observable<TeamsResponse>

    @Headers("X-Auth-Token: 7801836b9d924a48b2970153fe220b49", "X-Response-Control:minified")
    @GET("/v1/teams/{id}/players")
    fun getTeamPlayers(@Path("id") id: Int): Observable<PlayersResponse>

    @Headers("X-Auth-Token: 7801836b9d924a48b2970153fe220b49", "X-Response-Control:minified")
    @GET("/v1/competitions/{id}/leagueTable")
    fun getCompetitionTable(@Path("id") id: Int): Observable<LeagueTable>

    @Headers("X-Auth-Token: 7801836b9d924a48b2970153fe220b49", "X-Response-Control:minified")
    @GET("/v1/competitions/{id}/fixtures")
    fun getCompetitionFixtures(@Path("id") id: Int, @Query("timeFrameStart") timeFrameStart: String, @Query("timeFrameEnd") timeFrameEnd: String): Observable<FixturesResponse>

    @Headers("X-Auth-Token: 7801836b9d924a48b2970153fe220b49", "X-Response-Control:minified")
    @GET("/v1/fixtures")
    fun getFixtures(@Query("timeFrameStart") timeFrameStart: String, @Query("timeFrameEnd") timeFrameEnd: String): Observable<FixturesResponse>
}
