package com.molette.app.joursferies.core.di

import com.molette.app.joursferies.data.repositories.HolidayRepositoryImpl
import com.molette.app.joursferies.domain.repositories.HolidayRepository
import com.molette.app.joursferies.domain.usecases.GetHolidaysUseCase
import com.molette.app.joursferies.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var appModule = module {

    // Repositories
    factory<HolidayRepository> { HolidayRepositoryImpl(get(), get()) }

    // ViewModels
    viewModel { HomeViewModel(get()) }

    // Use Cases
    factory { GetHolidaysUseCase(get()) }
}