package com.rtukpe.fixtures.ui.competition.teams;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.rtukpe.fixtures.data.manager.DataManager;
import com.rtukpe.fixtures.data.model.Team;
import com.rtukpe.fixtures.ui.base.BasePresenter;
import com.rtukpe.fixtures.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class TeamsPresenter<V extends TeamsMvpView> extends BasePresenter<V> implements TeamsMvpContract<V> {

    @Inject
    public TeamsPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {
        super.onViewInitialized();
    }

    @Override
    public void getNotifications() {
        getCompositeDisposable().add(
                getDataManager()
                        .getMockTeams()
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(teamsResponse -> {
                            ArrayList<Team> teams = teamsResponse.teams;
                            teams = (ArrayList<Team>) Stream.of(teams).sortBy(team -> team.name).collect(Collectors.toList());
                            getMvpView().updateTeams(teams);
                        })

        );
    }
}
