package com.rtukpe.fixtures.ui.competition.teams

import com.annimon.stream.Collectors
import com.annimon.stream.Stream
import com.rtukpe.fixtures.data.manager.DataManager
import com.rtukpe.fixtures.data.model.Team
import com.rtukpe.fixtures.ui.base.BasePresenter
import com.rtukpe.fixtures.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class TeamsPresenter<V : TeamsMvpView> @Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V>(dataManager, schedulerProvider, compositeDisposable), TeamsMvpContract<V> {

    override fun onViewInitialized() {
        super.onViewInitialized()
    }

    override fun getTeams(id: Int) {
        compositeDisposable.add(
                dataManager
                        //.getMockTeams()
                        .getCompetitionTeams(id)
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribe({ teamsResponse ->
                            var teams = teamsResponse.teams
                            teams = Stream.of(teams).sortBy { team -> team.name }.collect(Collectors.toList()) as ArrayList<Team>
                            mvpView.updateTeams(teams)
                        }, { Timber.e(it) })

        )
    }
}
