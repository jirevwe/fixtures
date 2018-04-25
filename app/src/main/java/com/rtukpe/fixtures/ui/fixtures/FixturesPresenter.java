package com.rtukpe.fixtures.ui.fixtures;

import com.rtukpe.fixtures.data.manager.DataManager;
import com.rtukpe.fixtures.ui.base.BasePresenter;
import com.rtukpe.fixtures.utils.rx.SchedulerProvider;

import javax.inject.Inject;

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
                getDataManager()
                        .getFixtures("p1")
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(fixtures -> getMvpView().updateFixtures(fixtures.fixtures))
        );
    }
}
