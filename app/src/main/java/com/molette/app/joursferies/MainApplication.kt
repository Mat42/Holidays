package com.molette.app.joursferies

import android.app.Application
import com.molette.app.joursferies.core.di.appModule
import com.molette.app.joursferies.core.di.dbModule
import com.molette.app.joursferies.core.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(appModule, networkModule, dbModule)
        }
    }
}