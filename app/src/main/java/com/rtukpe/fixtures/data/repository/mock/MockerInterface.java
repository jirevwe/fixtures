package com.rtukpe.fixtures.data.repository.mock;

import com.rtukpe.fixtures.data.model.Movie;

import java.util.ArrayList;

import io.reactivex.Observable;

public interface MockerInterface {

    Observable<ArrayList<Movie>> getMovies();

}
