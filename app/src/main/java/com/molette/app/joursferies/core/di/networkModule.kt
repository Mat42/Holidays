package com.molette.app.joursferies.core.di

import com.molette.app.joursferies.data.network.RESTClient
import org.koin.dsl.module

var networkModule = module {

    single { RESTClient.createOkHttpClient() }
    single { RESTClient.getRetrofitInstance() }
    single { RESTClient.createGouvAPI(get()) }
}