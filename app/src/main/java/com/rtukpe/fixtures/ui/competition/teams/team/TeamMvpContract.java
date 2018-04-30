package com.rtukpe.fixtures.ui.competition.teams.team;

import com.rtukpe.fixtures.ui.base.MvpPresenter;

public interface TeamMvpContract<V extends TeamMvpView> extends MvpPresenter<V> {

    void getPlayers(int id);

}
