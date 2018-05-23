package com.rtukpe.fixtures.ui.competition.table

import com.rtukpe.fixtures.ui.base.MvpPresenter

interface TableMvpContract<V : TableMvpView> : MvpPresenter<V> {

    fun getCompetitionsTable(id: Int)

}
