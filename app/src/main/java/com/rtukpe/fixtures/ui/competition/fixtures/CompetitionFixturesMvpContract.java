package com.rtukpe.fixtures.ui.competition.fixtures;

import com.rtukpe.fixtures.ui.base.MvpPresenter;

public interface CompetitionFixturesMvpContract<V extends CompetitionFixturesMvpView> extends MvpPresenter<V> {

    void getFixtures();

}
