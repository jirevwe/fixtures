package com.rtukpe.fixtures.di.component;

import com.rtukpe.fixtures.di.annotations.PerActivity;
import com.rtukpe.fixtures.di.module.ActivityModule;
import com.rtukpe.fixtures.ui.competition.CompetitionActivity;
import com.rtukpe.fixtures.ui.competition.fixtures.CompetitionFixturesFragment;
import com.rtukpe.fixtures.ui.competition.table.TableFragment;
import com.rtukpe.fixtures.ui.competition.teams.TeamsFragment;
import com.rtukpe.fixtures.ui.competitions.CompetitionsFragment;
import com.rtukpe.fixtures.ui.fixtures.FixturesFragment;
import com.rtukpe.fixtures.ui.home.DashboardActivity;

import dagger.Component;

/**
 * Created by rtukpe on 13/03/2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    // Activities

    void inject(DashboardActivity activity);

    void inject(CompetitionActivity competitionActivity);

    // Fragments

    void inject(TableFragment tableFragment);

    void inject(TeamsFragment teamsFragment);

    void inject(FixturesFragment fixturesFragment);

    void inject(CompetitionsFragment competitionsFragment);

    void inject(CompetitionFixturesFragment competitionFixturesFragment);
}
