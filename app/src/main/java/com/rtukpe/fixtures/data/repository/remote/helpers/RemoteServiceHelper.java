package com.rtukpe.fixtures.data.repository.remote.helpers;

import com.rtukpe.fixtures.data.repository.remote.api.RemoteServiceApi;
import com.rtukpe.fixtures.data.repository.remote.helpers.base.BaseHelper;
import com.rtukpe.fixtures.data.repository.remote.responses.impl.MovieResponse;
import com.rtukpe.fixtures.data.repository.remote.responses.impl.MoviesResponse;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by rtukpe on 22/03/2018.
 */

public class RemoteServiceHelper extends BaseHelper implements RemoteServiceApi {

    private final RemoteServiceApi mRemoteServiceApi;

    @Inject
    public RemoteServiceHelper() {
        this.mRemoteServiceApi = createService(RemoteServiceApi.class);
    }

    @Override
    public Observable<MovieResponse> signUpUser(HashMap<String, Object> body) {
        return mRemoteServiceApi.signUpUser(body);
    }

    @Override
    public Observable<MovieResponse> signInUser(HashMap<String, Object> body) {
        return mRemoteServiceApi.signInUser(body);
    }

    @Override
    public Observable<MovieResponse> updateUser(String id) {
        return mRemoteServiceApi.updateUser(id);
    }

    @Override
    public Observable<MoviesResponse> getBooksRemote() {
        return mRemoteServiceApi.getBooksRemote();
    }

    @Override
    public Observable<MovieResponse> getBookRemote(String id) {
        return mRemoteServiceApi.getBookRemote(id);
    }
}
