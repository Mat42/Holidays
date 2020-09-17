package com.molette.app.joursferies.core.di

import com.molette.app.joursferies.data.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

var dbModule = module {

    single {
        AppDatabase.buildDb(androidContext())
    }
}