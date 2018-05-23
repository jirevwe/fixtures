package com.rtukpe.fixtures.ui.competition.teams

import com.rtukpe.fixtures.ui.base.MvpPresenter

interface TeamsMvpContract<V : TeamsMvpView> : MvpPresenter<V> {

    fun getTeams(id: Int)

}
