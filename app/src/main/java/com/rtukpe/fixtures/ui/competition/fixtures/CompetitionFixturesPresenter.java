package com.rtukpe.fixtures.ui.competition.fixtures;

import com.rtukpe.fixtures.data.manager.DataManager;
import com.rtukpe.fixtures.ui.base.BasePresenter;
import com.rtukpe.fixtures.utils.rx.SchedulerProvider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class CompetitionFixturesPresenter<V extends CompetitionFixturesMvpView> extends BasePresenter<V> implements CompetitionFixturesMvpContract<V> {

    @Inject
    public CompetitionFixturesPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {
        super.onViewInitialized();
    }

    @Override
    public void getFixtures() {
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE).format(new Date(System.currentTimeMillis()));
        getCompositeDisposable().add(
                getDataManager().getMockFixtures(date, date)
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(fixturesResponse -> getMvpView().updateFixtures(fixturesResponse.fixtures))
        );
    }
}
