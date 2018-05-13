package com.rtukpe.fixtures.data.repository.remote.helpers

import com.rtukpe.fixtures.data.model.*
import com.rtukpe.fixtures.data.repository.remote.api.RemoteServiceApi
import com.rtukpe.fixtures.data.repository.remote.helpers.base.BaseHelper
import io.reactivex.Observable
import java.util.*
import javax.inject.Inject

/**
 * Created by rtukpe on 22/03/2018.
 */

class RemoteServiceHelper @Inject
internal constructor() : BaseHelper(), RemoteServiceApi {

    private var mRemoteServiceApi: RemoteServiceApi

    override val competitions: Observable<ArrayList<Competition>>
        get() = mRemoteServiceApi.competitions

    init {
        this.mRemoteServiceApi = createService(RemoteServiceApi::class.java)
    }

    fun setRemoteServiceApi(mRemoteServiceApi: RemoteServiceApi) {
        this.mRemoteServiceApi = mRemoteServiceApi
    }

    override fun getCompetitionTeams(id: Int): Observable<TeamsResponse> {
        return mRemoteServiceApi.getCompetitionTeams(id)
    }

    override fun getTeamPlayers(id: Int): Observable<PlayersResponse> {
        return mRemoteServiceApi.getTeamPlayers(id)
    }

    override fun getCompetitionTable(id: Int): Observable<LeagueTable> {
        return mRemoteServiceApi.getCompetitionTable(id)
    }

    override fun getCompetitionFixtures(id: Int, timeFrameStart: String, timeFrameEnd: String): Observable<FixturesResponse> {
        return mRemoteServiceApi.getCompetitionFixtures(id, timeFrameStart, timeFrameEnd)
    }

    override fun getFixtures(timeFrameStart: String, timeFrameEnd: String): Observable<FixturesResponse> {
        return mRemoteServiceApi.getFixtures(timeFrameStart, timeFrameEnd)
    }
}
