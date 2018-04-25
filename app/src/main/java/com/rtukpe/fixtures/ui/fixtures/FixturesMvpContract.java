package com.rtukpe.fixtures.ui.fixtures;

import com.rtukpe.fixtures.ui.base.MvpPresenter;

public interface FixturesMvpContract<V extends FixturesMvpView> extends MvpPresenter<V> {

    void getFixtures();

}
