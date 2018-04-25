package com.rtukpe.fixtures.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.rtukpe.fixtures.di.annotations.ActivityContext;
import com.rtukpe.fixtures.di.annotations.PerActivity;
import com.rtukpe.fixtures.ui.competitions.CompetitionsAdapter;
import com.rtukpe.fixtures.ui.competitions.CompetitionsMvpContract;
import com.rtukpe.fixtures.ui.competitions.CompetitionsMvpView;
import com.rtukpe.fixtures.ui.competitions.CompetitionsPresenter;
import com.rtukpe.fixtures.ui.fixtures.FixturesAdapter;
import com.rtukpe.fixtures.ui.fixtures.FixturesMvpContract;
import com.rtukpe.fixtures.ui.fixtures.FixturesMvpView;
import com.rtukpe.fixtures.ui.fixtures.FixturesPresenter;
import com.rtukpe.fixtures.ui.home.DashboardMvpContract;
import com.rtukpe.fixtures.ui.home.DashboardMvpView;
import com.rtukpe.fixtures.ui.home.DashboardPresenter;
import com.rtukpe.fixtures.utils.rx.AppSchedulerProvider;
import com.rtukpe.fixtures.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by rtukpe on 13/03/2018.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    DashboardMvpContract<DashboardMvpView> provideDashboardPresenter(DashboardPresenter<DashboardMvpView> presenter) {
        return presenter;
    }

    @Provides
    FixturesMvpContract<FixturesMvpView> provideTitlesPresenter(FixturesPresenter<FixturesMvpView> presenter) {
        return presenter;
    }

    @Provides
    CompetitionsMvpContract<CompetitionsMvpView> provideFeedMvpPresenter(CompetitionsPresenter<CompetitionsMvpView> presenter) {
        return presenter;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    GridLayoutManager provideGridLayoutManager(AppCompatActivity activity) {
        return new GridLayoutManager(activity, 1);
    }

    @Provides
    FixturesAdapter provideOwnedBooksListAdapter(AppCompatActivity activity) {
        return new FixturesAdapter(activity);
    }

    @Provides
    CompetitionsAdapter provideFeedAdapter(AppCompatActivity activity) {
        return new CompetitionsAdapter(activity);
    }

    @Provides
    DividerItemDecoration provideDividerItemDecoration(AppCompatActivity activity) {
        return new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL);
    }
}
