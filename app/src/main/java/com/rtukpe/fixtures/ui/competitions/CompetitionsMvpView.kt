package com.rtukpe.fixtures.ui.competitions

import com.rtukpe.fixtures.data.model.Competition
import com.rtukpe.fixtures.ui.base.MvpView
import java.util.*

interface CompetitionsMvpView : MvpView {

    fun updateCompetitions(competitions: ArrayList<Competition>)

}
