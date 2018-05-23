package com.rtukpe.fixtures.ui.competition.table

import com.rtukpe.fixtures.data.model.LeagueTable
import com.rtukpe.fixtures.ui.base.MvpView
import java.util.*

interface TableMvpView : MvpView {

    fun updateTableStandings(standings: ArrayList<LeagueTable.Standing>)

}
