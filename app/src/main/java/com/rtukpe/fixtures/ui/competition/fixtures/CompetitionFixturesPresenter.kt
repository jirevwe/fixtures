package com.rtukpe.fixtures.ui.competition.fixtures

import com.rtukpe.fixtures.data.manager.DataManager
import com.rtukpe.fixtures.ui.base.BasePresenter
import com.rtukpe.fixtures.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class CompetitionFixturesPresenter<V : CompetitionFixturesMvpView> @Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable)
    : BasePresenter<V>(dataManager, schedulerProvider, compositeDisposable), CompetitionFixturesMvpContract<V> {

    override fun getFixtures(id: Int) {
        val date = SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE).format(Date(System.currentTimeMillis()))
        compositeDisposable.add(
                dataManager.getCompetitionFixtures(id, date, date)
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribe({ mvpView.updateFixtures(it.fixtures) }, { Timber.e(it) })
        )
    }
}
