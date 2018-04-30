package com.rtukpe.fixtures.ui.competitions;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.rtukpe.fixtures.data.manager.DataManager;
import com.rtukpe.fixtures.data.model.Competition;
import com.rtukpe.fixtures.ui.base.BasePresenter;
import com.rtukpe.fixtures.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

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
                        .getMockCompetitions()
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(competitions -> {
                            competitions = (ArrayList<Competition>) Stream.of(competitions).sortBy(competition -> competition.caption).collect(Collectors.toList());
                            getMvpView().updateCompetitions(competitions);
                        }, Timber::e)
        );
    }
}
