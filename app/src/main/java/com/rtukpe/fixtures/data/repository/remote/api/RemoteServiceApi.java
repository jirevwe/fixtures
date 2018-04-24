package com.rtukpe.fixtures.data.repository.remote.api;

import com.rtukpe.fixtures.data.repository.remote.responses.impl.MovieResponse;
import com.rtukpe.fixtures.data.repository.remote.responses.impl.MoviesResponse;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by rtukpe on 22/03/2018.
 */

public interface RemoteServiceApi {

    @POST("users/signup")
    Observable<MovieResponse> signUpUser(@Body HashMap<String, Object> body);

    @POST("users/signin")
    Observable<MovieResponse> signInUser(@Body HashMap<String, Object> body);

    @PUT("users/{id}")
    Observable<MovieResponse> updateUser(@Path("id") String id);

    @GET("books")
    Observable<MoviesResponse> getBooksRemote();

    @PUT("books/{id}")
    Observable<MovieResponse> getBookRemote(@Path("id") String id);
}
