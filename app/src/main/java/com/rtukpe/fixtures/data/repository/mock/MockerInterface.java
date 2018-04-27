package com.rtukpe.fixtures.data.repository.mock;

import com.rtukpe.fixtures.data.model.FixturesResponse;
import com.rtukpe.fixtures.data.model.TeamsResponse;

import io.reactivex.Observable;

public interface MockerInterface {

    Observable<FixturesResponse> getMockFixtures();

    Observable<TeamsResponse> getMockTeams();
}
