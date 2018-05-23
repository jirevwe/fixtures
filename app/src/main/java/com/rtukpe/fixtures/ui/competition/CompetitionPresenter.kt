package com.rtukpe.fixtures.ui.competition

import com.rtukpe.fixtures.data.manager.DataManager
import com.rtukpe.fixtures.ui.base.BasePresenter
import com.rtukpe.fixtures.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by rtukpe on 21/03/2018.
 */

class CompetitionPresenter<V : CompetitionMvpView> @Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable)
    : BasePresenter<V>(dataManager, schedulerProvider, compositeDisposable), CompetitionMvpContract<V> {

}
