package com.rtukpe.fixtures.di.component


import android.app.Application
import android.content.Context
import com.rtukpe.fixtures.data.manager.DataManager
import com.rtukpe.fixtures.di.annotations.ApplicationContext
import com.rtukpe.fixtures.di.module.ApplicationModule
import com.rtukpe.fixtures.root.MvpApp
import dagger.Component
import javax.inject.Singleton

/**
 * Created by rtukpe on 13/03/2018.
 */

@Singleton
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {

    val dataManager: DataManager

    fun inject(app: MvpApp)

    @ApplicationContext
    fun context(): Context

    fun application(): Application
}
