package com.rtukpe.fixtures.data.repository.remote.helpers;

import com.rtukpe.fixtures.data.model.Competition;
import com.rtukpe.fixtures.data.model.FixturesResponse;
import com.rtukpe.fixtures.data.model.LeagueTable;
import com.rtukpe.fixtures.data.model.TeamsResponse;
import com.rtukpe.fixtures.data.repository.remote.api.RemoteServiceApi;
import com.rtukpe.fixtures.data.repository.remote.helpers.base.BaseHelper;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by rtukpe on 22/03/2018.
 */

public class RemoteServiceHelper extends BaseHelper implements RemoteServiceApi {

    private final RemoteServiceApi mRemoteServiceApi;

    @Inject
    RemoteServiceHelper() {
        this.mRemoteServiceApi = createService(RemoteServiceApi.class);
    }

    @Override
    public Observable<ArrayList<Competition>> getCompetitions() {
        return mRemoteServiceApi.getCompetitions();
    }

    @Override
    public Observable<TeamsResponse> getCompetitionTeams(int id) {
        return mRemoteServiceApi.getCompetitionTeams(id);
    }

    @Override
    public Observable<LeagueTable> getCompetitionTable(int id) {
        return mRemoteServiceApi.getCompetitionTable(id);
    }

    @Override
    public Observable<FixturesResponse> getCompetitionFixtures(int id, String timeFrameStart, String timeFrameEnd) {
        return mRemoteServiceApi.getCompetitionFixtures(id, timeFrameStart, timeFrameEnd);
    }

    @Override
    public Observable<FixturesResponse> getFixtures(String timeFrameStart, String timeFrameEnd) {
        return mRemoteServiceApi.getFixtures(timeFrameStart, timeFrameEnd);
    }
}
