package com.rtukpe.fixtures.ui.competition.fixtures

import com.rtukpe.fixtures.data.model.Fixture
import com.rtukpe.fixtures.ui.base.MvpView
import java.util.*

interface CompetitionFixturesMvpView : MvpView {

    fun updateFixtures(fixtures: ArrayList<Fixture>)

}
