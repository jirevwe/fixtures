package com.rtukpe.fixtures.ui.fixtures;

import com.rtukpe.fixtures.data.manager.DataManager;
import com.rtukpe.fixtures.ui.base.BasePresenter;
import com.rtukpe.fixtures.utils.rx.SchedulerProvider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
//        Observable.zip(getDataManager().getFixtures("p1"),
//                getDataManager().getFixtures("n1"),
//                (fixturesResponse, fixturesResponse2) -> {
//                    fixturesResponse.fixtures.addAll(fixturesResponse2.fixtures);
//                    return fixturesResponse;
//                }).subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(fixturesResponse -> getMvpView().updateFixtures(fixturesResponse.fixtures));
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE).format(new Date(System.currentTimeMillis()));
        getCompositeDisposable().add(
                getDataManager().getFixtures(date, date)
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(fixturesResponse -> getMvpView().updateFixtures(fixturesResponse.fixtures))
        );
    }
}
