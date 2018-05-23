package com.rtukpe.fixtures.ui.competition.teams.team

import com.rtukpe.fixtures.data.model.Player
import com.rtukpe.fixtures.ui.base.DialogMvpView
import java.util.*

interface TeamMvpView : DialogMvpView {

    fun updatePlayers(players: ArrayList<Player>)
}
