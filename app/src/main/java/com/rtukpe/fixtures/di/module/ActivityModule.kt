package com.rtukpe.fixtures.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.rtukpe.fixtures.di.annotations.ActivityContext
import com.rtukpe.fixtures.di.annotations.PerActivity
import com.rtukpe.fixtures.ui.competition.CompetitionMvpContract
import com.rtukpe.fixtures.ui.competition.CompetitionMvpView
import com.rtukpe.fixtures.ui.competition.CompetitionPagerAdapter
import com.rtukpe.fixtures.ui.competition.CompetitionPresenter
import com.rtukpe.fixtures.ui.competition.fixtures.CompetitionFixturesAdapter
import com.rtukpe.fixtures.ui.competition.fixtures.CompetitionFixturesMvpContract
import com.rtukpe.fixtures.ui.competition.fixtures.CompetitionFixturesMvpView
import com.rtukpe.fixtures.ui.competition.fixtures.CompetitionFixturesPresenter
import com.rtukpe.fixtures.ui.competition.table.TableAdapter
import com.rtukpe.fixtures.ui.competition.table.TableMvpContract
import com.rtukpe.fixtures.ui.competition.table.TableMvpView
import com.rtukpe.fixtures.ui.competition.table.TablePresenter
import com.rtukpe.fixtures.ui.competition.teams.TeamsAdapter
import com.rtukpe.fixtures.ui.competition.teams.TeamsMvpContract
import com.rtukpe.fixtures.ui.competition.teams.TeamsMvpView
import com.rtukpe.fixtures.ui.competition.teams.TeamsPresenter
import com.rtukpe.fixtures.ui.competition.teams.team.PlayersAdapter
import com.rtukpe.fixtures.ui.competition.teams.team.TeamMvpContract
import com.rtukpe.fixtures.ui.competition.teams.team.TeamMvpView
import com.rtukpe.fixtures.ui.competition.teams.team.TeamPresenter
import com.rtukpe.fixtures.ui.competitions.CompetitionsAdapter
import com.rtukpe.fixtures.ui.competitions.CompetitionsMvpContract
import com.rtukpe.fixtures.ui.competitions.CompetitionsMvpView
import com.rtukpe.fixtures.ui.competitions.CompetitionsPresenter
import com.rtukpe.fixtures.ui.fixtures.FixturesAdapter
import com.rtukpe.fixtures.ui.fixtures.FixturesMvpContract
import com.rtukpe.fixtures.ui.fixtures.FixturesMvpView
import com.rtukpe.fixtures.ui.fixtures.FixturesPresenter
import com.rtukpe.fixtures.ui.home.DashboardMvpContract
import com.rtukpe.fixtures.ui.home.DashboardMvpView
import com.rtukpe.fixtures.ui.home.DashboardPresenter
import com.rtukpe.fixtures.utils.rx.AppSchedulerProvider
import com.rtukpe.fixtures.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by rtukpe on 13/03/2018.
 */

@Module
class ActivityModule(private val mActivity: AppCompatActivity) {

    @Provides
    @ActivityContext
    internal fun provideContext(): Context = mActivity

    @Provides
    internal fun provideActivity(): AppCompatActivity = mActivity

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

    @Provides
    internal fun provideLinearLayoutManager(activity: AppCompatActivity): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    internal fun provideGridLayoutManager(activity: AppCompatActivity): GridLayoutManager = GridLayoutManager(activity, 3)

    @Provides
    internal fun provideDividerItemDecoration(activity: AppCompatActivity): DividerItemDecoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)

    @Provides
    @PerActivity
    fun provideDashboardPresenter(presenter: DashboardPresenter<DashboardMvpView>): DashboardMvpContract<DashboardMvpView> = presenter

    @Provides
    @PerActivity
    fun provideCompetitionPresenter(presenter: CompetitionPresenter<CompetitionMvpView>): CompetitionMvpContract<CompetitionMvpView> = presenter

    @Provides
    fun provideFixturesPresenter(presenter: FixturesPresenter<FixturesMvpView>): FixturesMvpContract<FixturesMvpView> = presenter

    @Provides
    fun provideTeamPresenter(presenter: TeamPresenter<TeamMvpView>): TeamMvpContract<TeamMvpView> = presenter

    @Provides
    fun provideCompetitionFixturesPresenter(presenter: CompetitionFixturesPresenter<CompetitionFixturesMvpView>): CompetitionFixturesMvpContract<CompetitionFixturesMvpView> = presenter

    @Provides
    fun provideCompetitionsMvpPresenter(presenter: CompetitionsPresenter<CompetitionsMvpView>): CompetitionsMvpContract<CompetitionsMvpView> = presenter

    @Provides
    fun provideTeamsMvpPresenter(presenter: TeamsPresenter<TeamsMvpView>): TeamsMvpContract<TeamsMvpView> = presenter

    @Provides
    fun provideTableMvpPresenter(presenter: TablePresenter<TableMvpView>): TableMvpContract<TableMvpView> = presenter

    @Provides
    fun provideFixturesAdapter(activity: AppCompatActivity): FixturesAdapter = FixturesAdapter(activity)

    @Provides
    fun provideTeamsAdapter(activity: AppCompatActivity): TeamsAdapter = TeamsAdapter(activity)

    @Provides
    fun provideTableAdapter(activity: AppCompatActivity): TableAdapter = TableAdapter(activity)

    @Provides
    fun provideCompetitionsAdapter(activity: AppCompatActivity): CompetitionsAdapter = CompetitionsAdapter(activity)

    @Provides
    fun providePlayersAdapter(activity: AppCompatActivity): PlayersAdapter = PlayersAdapter(activity)

    @Provides
    fun provideCompetitionPagerAdapter(activity: AppCompatActivity): CompetitionPagerAdapter = CompetitionPagerAdapter(activity.supportFragmentManager)

    @Provides
    fun provideCompetitionFixturesAdapter(activity: AppCompatActivity): CompetitionFixturesAdapter = CompetitionFixturesAdapter(activity)
}
