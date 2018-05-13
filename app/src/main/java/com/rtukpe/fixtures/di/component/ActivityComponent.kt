package com.rtukpe.fixtures.di.component

import com.rtukpe.fixtures.di.annotations.PerActivity
import com.rtukpe.fixtures.di.module.ActivityModule
import com.rtukpe.fixtures.ui.competition.CompetitionActivity
import com.rtukpe.fixtures.ui.competition.fixtures.CompetitionFixturesFragment
import com.rtukpe.fixtures.ui.competition.table.TableFragment
import com.rtukpe.fixtures.ui.competition.teams.TeamsFragment
import com.rtukpe.fixtures.ui.competition.teams.team.TeamBottomSheetFragment
import com.rtukpe.fixtures.ui.competitions.CompetitionsFragment
import com.rtukpe.fixtures.ui.fixtures.FixturesFragment
import com.rtukpe.fixtures.ui.home.DashboardActivity
import dagger.Component


/**
 * Created by rtukpe on 13/03/2018.
 */

@PerActivity
@Component(dependencies = [(ApplicationComponent::class)], modules = [(ActivityModule::class)])
interface ActivityComponent {

    // Activities

    fun inject(activity: DashboardActivity)

    fun inject(competitionActivity: CompetitionActivity)

    // Fragments

    fun inject(tableFragment: TableFragment)

    fun inject(teamsFragment: TeamsFragment)

    fun inject(fixturesFragment: FixturesFragment)

    fun inject(competitionsFragment: CompetitionsFragment)

    fun inject(teamBottomSheetFragment: TeamBottomSheetFragment)

    fun inject(competitionFixturesFragment: CompetitionFixturesFragment)
}