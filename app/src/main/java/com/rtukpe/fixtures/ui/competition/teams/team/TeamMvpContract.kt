package com.rtukpe.fixtures.ui.competition.teams.team

import com.rtukpe.fixtures.ui.base.MvpPresenter

interface TeamMvpContract<V : TeamMvpView> : MvpPresenter<V> {

    fun getPlayers(id: Int)

}
