package com.rtukpe.fixtures.ui.competition;

import com.rtukpe.fixtures.data.manager.DataManager;
import com.rtukpe.fixtures.ui.base.BasePresenter;
import com.rtukpe.fixtures.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by rtukpe on 21/03/2018.
 */

public class CompetitionPresenter<V extends CompetitionMvpView> extends BasePresenter<V> implements CompetitionMvpContract<V> {

    @Inject
    public CompetitionPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {
        super.onViewInitialized();
    }
}
