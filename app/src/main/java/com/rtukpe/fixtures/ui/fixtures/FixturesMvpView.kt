package com.rtukpe.fixtures.ui.fixtures

import com.rtukpe.fixtures.data.model.Fixture
import com.rtukpe.fixtures.ui.base.MvpView
import java.util.*

interface FixturesMvpView : MvpView {

    fun updateFixtures(fixtures: ArrayList<Fixture>)

}
