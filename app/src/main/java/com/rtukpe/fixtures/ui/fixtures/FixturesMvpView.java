package com.rtukpe.fixtures.ui.fixtures;

import com.rtukpe.fixtures.data.model.Fixture;
import com.rtukpe.fixtures.ui.base.MvpView;

import java.util.ArrayList;

public interface FixturesMvpView extends MvpView {

    void updateFixtures(ArrayList<Fixture> fixtures);

}
