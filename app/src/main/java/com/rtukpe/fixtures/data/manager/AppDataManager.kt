package com.rtukpe.fixtures.data.manager

import android.content.Context
import com.rtukpe.fixtures.data.model.*
import com.rtukpe.fixtures.data.repository.mock.MockHelper
import com.rtukpe.fixtures.data.repository.remote.helpers.RemoteServiceHelper
import com.rtukpe.fixtures.di.annotations.ApplicationContext
import io.reactivex.Observable
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by rtukpe on 14/03/2018.
 */

@Singleton
class AppDataManager
@Inject
internal constructor(@param:ApplicationContext val context: Context,
                     private val mRemoteServiceHelper: RemoteServiceHelper,
                     private val mMockHelper: MockHelper) : DataManager {
    override val mockTeamPlayers: PlayersResponse
        get() = mMockHelper.mockTeamPlayers

    override val mockCompetitionTable: Observable<LeagueTable>
        get() = mMockHelper.mockCompetitionTable

    override val mockTeams: Observable<TeamsResponse>
        get() = mMockHelper.mockTeams

    override val mockCompetitions: Observable<ArrayList<Competition>>
        get() = mMockHelper.mockCompetitions

    override val competitions: Observable<ArrayList<Competition>> = mRemoteServiceHelper.competitions

    override fun getCompetitionTeams(id: Int): Observable<TeamsResponse> = mRemoteServiceHelper.getCompetitionTeams(id)

    override fun getTeamPlayers(id: Int): Observable<PlayersResponse> {
        return mRemoteServiceHelper.getTeamPlayers(id)
    }

    override fun getCompetitionTable(id: Int): Observable<LeagueTable> {
        return mRemoteServiceHelper.getCompetitionTable(id)
    }

    override fun getCompetitionFixtures(id: Int, timeFrameStart: String, timeFrameEnd: String): Observable<FixturesResponse> {
        return mRemoteServiceHelper.getCompetitionFixtures(id, timeFrameStart, timeFrameEnd)
    }

    override fun getFixtures(timeFrameStart: String, timeFrameEnd: String): Observable<FixturesResponse> {
        return mRemoteServiceHelper.getFixtures(timeFrameStart, timeFrameEnd)
    }

    override fun getMockFixtures(timeFrameStart: String, timeFrameEnd: String): Observable<FixturesResponse> {
        return mMockHelper.getMockFixtures(timeFrameStart, timeFrameEnd)
    }
}
