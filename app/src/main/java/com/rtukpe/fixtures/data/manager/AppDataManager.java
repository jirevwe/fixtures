package com.rtukpe.fixtures.data.manager;

import android.content.Context;

import com.rtukpe.fixtures.data.model.Competition;
import com.rtukpe.fixtures.data.model.FixturesResponse;
import com.rtukpe.fixtures.data.model.LeagueTable;
import com.rtukpe.fixtures.data.model.PlayersResponse;
import com.rtukpe.fixtures.data.model.TeamsResponse;
import com.rtukpe.fixtures.data.repository.mock.MockHelper;
import com.rtukpe.fixtures.data.repository.remote.helpers.RemoteServiceHelper;
import com.rtukpe.fixtures.di.annotations.ApplicationContext;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by rtukpe on 14/03/2018.
 */

@Singleton
public class AppDataManager implements DataManager {

    private Context mContext;
    private RemoteServiceHelper mRemoteServiceHelper;
    private MockHelper mMockHelper;

    @Inject
    AppDataManager(@ApplicationContext Context mContext,
                   RemoteServiceHelper mRemoteServiceHelper,
                   MockHelper mockHelper) {
        this.mContext = mContext;
        this.mRemoteServiceHelper = mRemoteServiceHelper;
        this.mMockHelper = mockHelper;
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public Observable<ArrayList<Competition>> getCompetitions() {
        return mRemoteServiceHelper.getCompetitions();
    }

    @Override
    public Observable<TeamsResponse> getCompetitionTeams(int id) {
        return mRemoteServiceHelper.getCompetitionTeams(id);
    }

    @Override
    public Observable<PlayersResponse> getTeamPlayers(int id) {
        return mRemoteServiceHelper.getTeamPlayers(id);
    }

    @Override
    public Observable<LeagueTable> getCompetitionTable(int id) {
        return mRemoteServiceHelper.getCompetitionTable(id);
    }

    @Override
    public Observable<FixturesResponse> getCompetitionFixtures(int id, String timeFrameStart, String timeFrameEnd) {
        return mRemoteServiceHelper.getCompetitionFixtures(id, timeFrameStart, timeFrameEnd);
    }

    @Override
    public Observable<FixturesResponse> getFixtures(String timeFrameStart, String timeFrameEnd) {
        return mRemoteServiceHelper.getFixtures(timeFrameStart, timeFrameEnd);
    }

    @Override
    public PlayersResponse getMockTeamPlayers() {
        return mMockHelper.getMockTeamPlayers();
    }

    @Override
    public Observable<LeagueTable> getMockCompetitionTable() {
        return mMockHelper.getMockCompetitionTable();
    }

    @Override
    public Observable<FixturesResponse> getMockFixtures(String timeFrameStart, String timeFrameEnd) {
        return mMockHelper.getMockFixtures(timeFrameStart, timeFrameEnd);
    }

    @Override
    public Observable<TeamsResponse> getMockTeams() {
        return mMockHelper.getMockTeams();
    }

    @Override
    public Observable<ArrayList<Competition>> getMockCompetitions() {
        return mMockHelper.getMockCompetitions();
    }
}
