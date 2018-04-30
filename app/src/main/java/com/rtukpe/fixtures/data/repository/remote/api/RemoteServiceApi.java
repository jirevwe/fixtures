package com.rtukpe.fixtures.data.repository.remote.api;

import com.rtukpe.fixtures.data.model.Competition;
import com.rtukpe.fixtures.data.model.FixturesResponse;
import com.rtukpe.fixtures.data.model.LeagueTable;
import com.rtukpe.fixtures.data.model.PlayersResponse;
import com.rtukpe.fixtures.data.model.TeamsResponse;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rtukpe on 22/03/2018.
 */

public interface RemoteServiceApi {

    @Headers({"X-Auth-Token: 7801836b9d924a48b2970153fe220b49", "X-Response-Control:minified"})
    @GET("/v1/competitions")
    Observable<ArrayList<Competition>> getCompetitions();

    @Headers({"X-Auth-Token: 7801836b9d924a48b2970153fe220b49", "X-Response-Control:minified"})
    @GET("/v1/competitions/{id}/teams")
    Observable<TeamsResponse> getCompetitionTeams(@Path("id") int id);

    @Headers({"X-Auth-Token: 7801836b9d924a48b2970153fe220b49", "X-Response-Control:minified"})
    @GET("/v1/teams/{id}/players")
    Call<PlayersResponse> getTeamPlayers(@Path("id") int id);

    @Headers({"X-Auth-Token: 7801836b9d924a48b2970153fe220b49", "X-Response-Control:minified"})
    @GET("/v1/competitions/{id}/leagueTable")
    Observable<LeagueTable> getCompetitionTable(@Path("id") int id);

    @Headers({"X-Auth-Token: 7801836b9d924a48b2970153fe220b49", "X-Response-Control:minified"})
    @GET("/v1/competitions/{id}/fixtures")
    Observable<FixturesResponse> getCompetitionFixtures(@Path("id") int id, @Query("timeFrameStart") String timeFrameStart, @Query("timeFrameEnd") String timeFrameEnd);

    @Headers({"X-Auth-Token: 7801836b9d924a48b2970153fe220b49", "X-Response-Control:minified"})
    @GET("/v1/fixtures")
    Observable<FixturesResponse> getFixtures(@Query("timeFrameStart") String timeFrameStart, @Query("timeFrameEnd") String timeFrameEnd);
}
