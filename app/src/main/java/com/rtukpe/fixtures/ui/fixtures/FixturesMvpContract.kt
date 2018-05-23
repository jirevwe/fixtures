package com.rtukpe.fixtures.ui.fixtures

import com.rtukpe.fixtures.ui.base.MvpPresenter

interface FixturesMvpContract<V : FixturesMvpView> : MvpPresenter<V> {

    fun getFixtures()

}
