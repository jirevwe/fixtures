package com.rtukpe.fixtures.data.manager;

import android.content.Context;

import com.rtukpe.fixtures.data.model.Movie;
import com.rtukpe.fixtures.data.repository.local.helper.LocalDataHelper;
import com.rtukpe.fixtures.data.repository.mock.MockHelper;
import com.rtukpe.fixtures.data.repository.remote.helpers.RemoteServiceHelper;
import com.rtukpe.fixtures.data.repository.remote.responses.impl.MovieResponse;
import com.rtukpe.fixtures.data.repository.remote.responses.impl.MoviesResponse;
import com.rtukpe.fixtures.di.annotations.ApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;

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
    private LocalDataHelper mLocalDataHelper;
    private MockHelper mMockHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context mContext,
                          RemoteServiceHelper mRemoteServiceHelper,
                          LocalDataHelper mLocalDataHelper,
                          MockHelper mockHelper) {
        this.mContext = mContext;
        this.mRemoteServiceHelper = mRemoteServiceHelper;
        this.mLocalDataHelper = mLocalDataHelper;
        this.mMockHelper = mockHelper;
    }

    @Override
    public Observable<MovieResponse> signUpUser(HashMap<String, Object> body) {
        return mRemoteServiceHelper.signUpUser(body);
    }

    @Override
    public Observable<MovieResponse> signInUser(HashMap<String, Object> body) {
        return mRemoteServiceHelper.signInUser(body);
    }

    @Override
    public Observable<MovieResponse> updateUser(String id) {
        return mRemoteServiceHelper.updateUser(id);
    }

    @Override
    public Observable<MoviesResponse> getBooksRemote() {
        return mRemoteServiceHelper.getBooksRemote();
    }

    @Override
    public Observable<MovieResponse> getBookRemote(String id) {
        return mRemoteServiceHelper.getBookRemote(id);
    }

    @Override
    public Observable<ArrayList<Movie>> getMovies() {
        return mMockHelper.getMovies();
    }
}
