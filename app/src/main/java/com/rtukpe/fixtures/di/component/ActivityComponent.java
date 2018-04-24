package com.rtukpe.fixtures.di.component;

import com.rtukpe.fixtures.di.annotations.PerActivity;
import com.rtukpe.fixtures.di.module.ActivityModule;
import com.rtukpe.fixtures.ui.feed.CompetitionsFragment;
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

    // Fragments

    void inject(CompetitionsFragment competitionsFragment);

    void inject(FixturesFragment fixturesFragment);
}
