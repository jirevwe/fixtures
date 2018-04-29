package com.rtukpe.fixtures.ui.competition.fixtures;

import com.rtukpe.fixtures.data.model.Fixture;
import com.rtukpe.fixtures.ui.base.MvpView;

import java.util.ArrayList;

public interface CompetitionFixturesMvpView extends MvpView {

    void updateFixtures(ArrayList<Fixture> fixtures);

}
