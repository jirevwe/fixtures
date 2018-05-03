package com.rtukpe.fixtures.ui.competition.teams.team;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.rtukpe.fixtures.data.manager.DataManager;
import com.rtukpe.fixtures.data.model.Player;
import com.rtukpe.fixtures.ui.base.BasePresenter;
import com.rtukpe.fixtures.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

public class TeamPresenter<Z extends TeamMvpView> extends BasePresenter<Z> implements TeamMvpContract<Z> {

    @Inject
    public TeamPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {
        super.onViewInitialized();
    }


    @Override
    public void getPlayers(int id) {
        getCompositeDisposable().add(
                getDataManager()
                        .getTeamPlayers(id)
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(playersResponse -> {
                            ArrayList<Player> players = playersResponse.players;
                            players = (ArrayList<Player>) Stream.of(players).sortBy(player -> player.jerseyNumber).collect(Collectors.toList());
                            getMvpView().updatePlayers(players);
                        }, throwable -> {
                            Timber.w(throwable);
                            getMvpView().show(throwable.getMessage(), true);
                        })
        );
    }
}
