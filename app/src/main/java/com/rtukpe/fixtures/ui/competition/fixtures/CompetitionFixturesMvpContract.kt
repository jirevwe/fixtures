package com.rtukpe.fixtures.ui.competition.fixtures

import com.rtukpe.fixtures.ui.base.MvpPresenter

interface CompetitionFixturesMvpContract<V : CompetitionFixturesMvpView> : MvpPresenter<V> {

    fun getFixtures(id: Int)

}
