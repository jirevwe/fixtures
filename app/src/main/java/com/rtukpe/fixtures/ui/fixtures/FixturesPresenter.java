package com.rtukpe.fixtures.ui.fixtures;

import com.rtukpe.fixtures.data.manager.DataManager;
import com.rtukpe.fixtures.ui.base.BasePresenter;
import com.rtukpe.fixtures.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

public class FixturesPresenter<V extends FixturesMvpView> extends BasePresenter<V> implements FixturesMvpContract<V> {

    @Inject
    public FixturesPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {
        super.onViewInitialized();
    }

    @Override
    public void getFixtures() {
        getCompositeDisposable().add(
                Observable.zip(getDataManager().getFixtures("p1"),
                        getDataManager().getFixtures("n1"),
                        (fixturesResponse, fixturesResponse2) -> {
                            fixturesResponse.fixtures.addAll(fixturesResponse2.fixtures);
                            return fixturesResponse;
                        }).subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(fixturesResponse -> getMvpView().updateFixtures(fixturesResponse.fixtures))
        );
    }
}
