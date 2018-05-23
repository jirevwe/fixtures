package com.rtukpe.fixtures.ui.competition.teams.team

import com.annimon.stream.Collectors
import com.annimon.stream.Stream
import com.rtukpe.fixtures.data.manager.DataManager
import com.rtukpe.fixtures.data.model.Player
import com.rtukpe.fixtures.ui.base.BasePresenter
import com.rtukpe.fixtures.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class TeamPresenter<Z : TeamMvpView> @Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<Z>(dataManager, schedulerProvider, compositeDisposable), TeamMvpContract<Z> {

    override fun onViewInitialized() {
        super.onViewInitialized()
    }


    override fun getPlayers(id: Int) {
        compositeDisposable.add(
                dataManager
                        .getTeamPlayers(id)
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribe({ playersResponse ->
                            var players = playersResponse.players
                            players = Stream.of(players).sortBy { player -> player.jerseyNumber }.collect(Collectors.toList()) as ArrayList<Player>
                            mvpView.updatePlayers(players)
                        }, { throwable ->
                            Timber.w(throwable)
                            mvpView.show(throwable.message!!, true)
                        })
        )
    }
}
