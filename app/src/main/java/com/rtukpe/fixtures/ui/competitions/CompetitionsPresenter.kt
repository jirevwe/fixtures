package com.rtukpe.fixtures.ui.competitions

import com.annimon.stream.Collectors
import com.annimon.stream.Stream
import com.rtukpe.fixtures.data.manager.DataManager
import com.rtukpe.fixtures.data.model.Competition
import com.rtukpe.fixtures.ui.base.BasePresenter
import com.rtukpe.fixtures.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class CompetitionsPresenter<V : CompetitionsMvpView> @Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V>(dataManager, schedulerProvider, compositeDisposable), CompetitionsMvpContract<V> {

    override fun getCompetitions() {
        compositeDisposable.add(
                dataManager
                        .mockCompetitions
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribe({
                            val orderedCompetitions = Stream.of(it).sortBy { competition -> competition.caption }.collect(Collectors.toList()) as ArrayList<Competition>
                            mvpView.updateCompetitions(orderedCompetitions)
                        }, { Timber.e(it) })
        )
    }
}
