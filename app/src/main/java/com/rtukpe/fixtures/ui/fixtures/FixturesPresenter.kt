package com.rtukpe.fixtures.ui.fixtures

import com.rtukpe.fixtures.data.manager.DataManager
import com.rtukpe.fixtures.ui.base.BasePresenter
import com.rtukpe.fixtures.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class FixturesPresenter<V : FixturesMvpView> @Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V>(dataManager, schedulerProvider, compositeDisposable), FixturesMvpContract<V> {

    override fun onViewInitialized() {
        super.onViewInitialized()
    }

    override fun getFixtures() {
        //        Observable.zip(getDataManager().getCompetitionsTable("p1"),
        //                getDataManager().getCompetitionsTable("n1"),
        //                (fixturesResponse, fixturesResponse2) -> {
        //                    fixturesResponse.fixtures.addAll(fixturesResponse2.fixtures);
        //                    return fixturesResponse;
        //                }).subscribeOn(getSchedulerProvider().io())
        //                .observeOn(getSchedulerProvider().ui())
        //                .subscribe(fixturesResponse -> getMvpView().updateTableStandings(fixturesResponse.fixtures));
        val date = SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE).format(Date(System.currentTimeMillis()))
        compositeDisposable.add(
                dataManager.getMockFixtures(date, date)
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribe({ mvpView.updateFixtures(it.fixtures) }, { Timber.w(it) })
        )
    }
}
