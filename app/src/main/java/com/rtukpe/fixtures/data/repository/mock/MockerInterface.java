package com.rtukpe.fixtures.data.repository.mock;

import com.rtukpe.fixtures.data.model.Competition;
import com.rtukpe.fixtures.data.model.FixturesResponse;
import com.rtukpe.fixtures.data.model.LeagueTable;
import com.rtukpe.fixtures.data.model.PlayersResponse;
import com.rtukpe.fixtures.data.model.TeamsResponse;

import java.util.ArrayList;

import io.reactivex.Observable;

public interface MockerInterface {

    PlayersResponse getMockTeamPlayers();

    Observable<LeagueTable> getMockCompetitionTable();

    Observable<FixturesResponse> getMockFixtures(String timeFrameStart, String timeFrameEnd);

    Observable<TeamsResponse> getMockTeams();

    Observable<ArrayList<Competition>> getMockCompetitions();
}
