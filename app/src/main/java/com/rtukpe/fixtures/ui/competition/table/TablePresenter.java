package com.rtukpe.fixtures.ui.competition.table;

import com.rtukpe.fixtures.data.manager.DataManager;
import com.rtukpe.fixtures.ui.base.BasePresenter;
import com.rtukpe.fixtures.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class TablePresenter<V extends TableMvpView> extends BasePresenter<V> implements TableMvpContract<V> {

    @Inject
    public TablePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {
        super.onViewInitialized();
    }

    @Override
    public void getCompetitionsTable() {
        getCompositeDisposable().add(
                getDataManager().getMockCompetitionTable()
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(leagueTable -> getMvpView().updateTableStandings(leagueTable.standing))
        );
    }
}
