package com.rtukpe.fixtures.di.component;


import android.app.Application;
import android.content.Context;

import com.rtukpe.fixtures.data.manager.DataManager;
import com.rtukpe.fixtures.di.annotations.ApplicationContext;
import com.rtukpe.fixtures.di.module.ApplicationModule;
import com.rtukpe.fixtures.root.MvpApp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rtukpe on 13/03/2018.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
