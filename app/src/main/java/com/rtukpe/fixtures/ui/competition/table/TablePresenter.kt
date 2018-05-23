package com.rtukpe.fixtures.ui.competition.table

import com.rtukpe.fixtures.data.manager.DataManager
import com.rtukpe.fixtures.ui.base.BasePresenter
import com.rtukpe.fixtures.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class TablePresenter<V : TableMvpView> @Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V>(dataManager, schedulerProvider, compositeDisposable), TableMvpContract<V> {

    override fun onViewInitialized() {
        super.onViewInitialized()
    }

    override fun getCompetitionsTable(id: Int) {
        compositeDisposable.add(
                dataManager.getCompetitionTable(id)
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribe({ mvpView.updateTableStandings(it.standing) }, { Timber.e(it) })
        )
    }
}
