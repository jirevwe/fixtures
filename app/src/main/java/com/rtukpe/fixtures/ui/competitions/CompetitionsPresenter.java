package com.rtukpe.fixtures.ui.competitions;

import com.rtukpe.fixtures.data.manager.DataManager;
import com.rtukpe.fixtures.ui.base.BasePresenter;
import com.rtukpe.fixtures.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class CompetitionsPresenter<V extends CompetitionsMvpView> extends BasePresenter<V> implements CompetitionsMvpContract<V> {

    @Inject
    public CompetitionsPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {
        super.onViewInitialized();
    }

    @Override
    public void getCompetitions() {
        getCompositeDisposable().add(
                getDataManager()
                        .getCompetitions()
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(competitions -> getMvpView().updateCompetitions(competitions))
        );
    }
}
