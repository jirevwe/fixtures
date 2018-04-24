package com.rtukpe.fixtures.root;


import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.rtukpe.fixtures.R;
import com.rtukpe.fixtures.di.component.ApplicationComponent;
import com.rtukpe.fixtures.di.component.DaggerApplicationComponent;
import com.rtukpe.fixtures.di.module.ApplicationModule;
import com.rtukpe.fixtures.utils.others.AppLogger;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MvpApp extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);

        //App logger
        AppLogger.init();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/RobotoCondensed-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
