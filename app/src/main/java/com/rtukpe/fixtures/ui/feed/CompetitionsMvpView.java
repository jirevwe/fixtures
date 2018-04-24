package com.rtukpe.fixtures.ui.feed;

import com.rtukpe.fixtures.data.model.Movie;
import com.rtukpe.fixtures.ui.base.MvpView;

import java.util.ArrayList;

public interface CompetitionsMvpView extends MvpView {

    void updateBooks(ArrayList<Movie> movies);

}
