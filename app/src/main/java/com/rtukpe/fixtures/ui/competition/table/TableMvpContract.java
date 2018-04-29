package com.rtukpe.fixtures.ui.competition.table;

import com.rtukpe.fixtures.ui.base.MvpPresenter;

public interface TableMvpContract<V extends TableMvpView> extends MvpPresenter<V> {

    void getCompetitionsTable(int id);

}
