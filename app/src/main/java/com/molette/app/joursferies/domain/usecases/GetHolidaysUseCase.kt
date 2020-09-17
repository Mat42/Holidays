package com.molette.app.joursferies.domain.usecases

import android.util.Log
import com.molette.app.joursferies.core.common.enums.Zone
import com.molette.app.joursferies.data.db.models.HolidayDb
import com.molette.app.joursferies.domain.repositories.HolidayRepository
import kotlinx.coroutines.flow.Flow

class GetHolidaysUseCase(private val repository: HolidayRepository) {

    suspend fun getHolidaysRemote(zone: Zone, year: Int){
        repository.getHolidaysRemote(zone, year)
    }

    fun getHolidaysLocal(zone: Zone, year: Int): Flow<List<HolidayDb>> {
        return repository.getHolidaysLocal(zone, year)
    }
}