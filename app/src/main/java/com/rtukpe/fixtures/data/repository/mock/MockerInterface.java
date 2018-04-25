package com.rtukpe.fixtures.data.repository.mock;

import com.rtukpe.fixtures.data.model.FixturesResponse;

import io.reactivex.Observable;

public interface MockerInterface {

    Observable<FixturesResponse> getMockFixtures();
}
