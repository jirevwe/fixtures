package com.rtukpe.fixtures.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.rtukpe.fixtures.di.annotations.ActivityContext;
import com.rtukpe.fixtures.di.annotations.PerActivity;
import com.rtukpe.fixtures.ui.competition.CompetitionMvpContract;
import com.rtukpe.fixtures.ui.competition.CompetitionMvpView;
import com.rtukpe.fixtures.ui.competition.CompetitionPagerAdapter;
import com.rtukpe.fixtures.ui.competition.CompetitionPresenter;
import com.rtukpe.fixtures.ui.competition.fixtures.CompetitionFixturesAdapter;
import com.rtukpe.fixtures.ui.competition.fixtures.CompetitionFixturesMvpContract;
import com.rtukpe.fixtures.ui.competition.fixtures.CompetitionFixturesMvpView;
import com.rtukpe.fixtures.ui.competition.fixtures.CompetitionFixturesPresenter;
import com.rtukpe.fixtures.ui.competition.table.TableAdapter;
import com.rtukpe.fixtures.ui.competition.table.TableMvpContract;
import com.rtukpe.fixtures.ui.competition.table.TableMvpView;
import com.rtukpe.fixtures.ui.competition.table.TablePresenter;
import com.rtukpe.fixtures.ui.competition.teams.TeamsAdapter;
import com.rtukpe.fixtures.ui.competition.teams.TeamsMvpContract;
import com.rtukpe.fixtures.ui.competition.teams.TeamsMvpView;
import com.rtukpe.fixtures.ui.competition.teams.TeamsPresenter;
import com.rtukpe.fixtures.ui.competition.teams.team.PlayersAdapter;
import com.rtukpe.fixtures.ui.competition.teams.team.TeamMvpContract;
import com.rtukpe.fixtures.ui.competition.teams.team.TeamMvpView;
import com.rtukpe.fixtures.ui.competition.teams.team.TeamPresenter;
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
    @PerActivity
    CompetitionMvpContract<CompetitionMvpView> provideCompetitionPresenter(CompetitionPresenter<CompetitionMvpView> presenter) {
        return presenter;
    }

    @Provides
    FixturesMvpContract<FixturesMvpView> provideFixturesPresenter(FixturesPresenter<FixturesMvpView> presenter) {
        return presenter;
    }

    @Provides
    TeamMvpContract<TeamMvpView> provideTeamPresenter(TeamPresenter<TeamMvpView> presenter) {
        return presenter;
    }

    @Provides
    CompetitionFixturesMvpContract<CompetitionFixturesMvpView> provideCompetitionFixturesPresenter(CompetitionFixturesPresenter<CompetitionFixturesMvpView> presenter) {
        return presenter;
    }

    @Provides
    CompetitionsMvpContract<CompetitionsMvpView> provideCompetitionsMvpPresenter(CompetitionsPresenter<CompetitionsMvpView> presenter) {
        return presenter;
    }

    @Provides
    TeamsMvpContract<TeamsMvpView> provideTeamsMvpPresenter(TeamsPresenter<TeamsMvpView> presenter) {
        return presenter;
    }

    @Provides
    TableMvpContract<TableMvpView> provideTableMvpPresenter(TablePresenter<TableMvpView> presenter) {
        return presenter;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    GridLayoutManager provideGridLayoutManager(AppCompatActivity activity) {
        return new GridLayoutManager(activity, 3);
    }

    @Provides
    FixturesAdapter provideFixturesAdapter(AppCompatActivity activity) {
        return new FixturesAdapter(activity);
    }

    @Provides
    TeamsAdapter provideTeamsAdapter(AppCompatActivity activity) {
        return new TeamsAdapter(activity);
    }

    @Provides
    TableAdapter provideTableAdapter(AppCompatActivity activity) {
        return new TableAdapter(activity);
    }

    @Provides
    CompetitionsAdapter provideCompetitionsAdapter(AppCompatActivity activity) {
        return new CompetitionsAdapter(activity);
    }

    @Provides
    PlayersAdapter providePlayersAdapter(AppCompatActivity activity) {
        return new PlayersAdapter(activity);
    }

    @Provides
    CompetitionPagerAdapter provideCompetitionPagerAdapter(AppCompatActivity activity) {
        return new CompetitionPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    CompetitionFixturesAdapter provideCompetitionFixturesAdapter(AppCompatActivity activity) {
        return new CompetitionFixturesAdapter(activity);
    }

    @Provides
    DividerItemDecoration provideDividerItemDecoration(AppCompatActivity activity) {
        return new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL);
    }
}
