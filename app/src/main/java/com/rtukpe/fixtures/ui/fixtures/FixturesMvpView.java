package com.rtukpe.fixtures.ui.fixtures;

import com.rtukpe.fixtures.data.model.Movie;
import com.rtukpe.fixtures.ui.base.MvpView;

import java.util.ArrayList;

public interface FixturesMvpView extends MvpView {

    void updateBooks(ArrayList<Movie> movies);

}
