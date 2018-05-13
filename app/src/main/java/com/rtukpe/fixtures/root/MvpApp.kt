package com.rtukpe.fixtures.root


import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.rtukpe.fixtures.R
import com.rtukpe.fixtures.di.component.ApplicationComponent
import com.rtukpe.fixtures.di.component.DaggerApplicationComponent
import com.rtukpe.fixtures.di.module.ApplicationModule
import com.rtukpe.fixtures.utils.others.AppLogger
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class MvpApp : Application() {

    // Needed to replace the component with a test specific one
    var component: ApplicationComponent? = null

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        component!!.inject(this)

        //App logger
        AppLogger.init()

        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("font/RobotoCondensed-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
    }
}
