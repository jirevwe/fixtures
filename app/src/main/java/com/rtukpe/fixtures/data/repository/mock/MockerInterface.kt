package com.rtukpe.fixtures.data.repository.mock

import com.rtukpe.fixtures.data.model.*
import io.reactivex.Observable
import java.util.*

interface MockerInterface {

    val mockTeamPlayers: PlayersResponse

    val mockCompetitionTable: Observable<LeagueTable>

    val mockTeams: Observable<TeamsResponse>

    val mockCompetitions: Observable<ArrayList<Competition>>

    fun getMockFixtures(timeFrameStart: String, timeFrameEnd: String): Observable<FixturesResponse>
}
