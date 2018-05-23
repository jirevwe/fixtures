package com.rtukpe.fixtures.ui.competitions

import com.rtukpe.fixtures.ui.base.MvpPresenter

interface CompetitionsMvpContract<V : CompetitionsMvpView> : MvpPresenter<V> {

    fun getCompetitions()

}
