package com.rtukpe.fixtures.ui.competition.teams;

import com.rtukpe.fixtures.ui.base.MvpPresenter;

public interface TeamsMvpContract<V extends TeamsMvpView> extends MvpPresenter<V> {

    void getTeams(int id);

}
