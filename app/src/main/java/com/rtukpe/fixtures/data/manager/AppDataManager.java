package com.rtukpe.fixtures.data.manager;

import android.content.Context;

import com.rtukpe.fixtures.data.model.Competition;
import com.rtukpe.fixtures.data.model.FixturesResponse;
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

    private static final String TAG = "AppDataManager";

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
    public Observable<FixturesResponse> getFixtures(String timeFrame) {
        return mRemoteServiceHelper.getFixtures(timeFrame);
    }

    @Override
    public Observable<FixturesResponse> getMockFixtures() {
        return mMockHelper.getMockFixtures();
    }

    @Override
    public Observable<TeamsResponse> getMockTeams() {
        return mMockHelper.getMockTeams();
    }
}
