package com.rtukpe.fixtures.di.module


import android.app.Application
import android.content.Context
import com.rtukpe.fixtures.data.manager.AppDataManager
import com.rtukpe.fixtures.data.manager.DataManager
import com.rtukpe.fixtures.di.annotations.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by rtukpe on 13/03/2018.
 */

@Module
class ApplicationModule(private val mApplication: Application) {

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context = mApplication

    @Provides
    internal fun provideApplication(): Application = mApplication

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager = appDataManager
}
