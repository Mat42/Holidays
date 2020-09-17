package com.molette.app.joursferies.domain.repositories

import com.molette.app.joursferies.core.common.enums.Zone
import com.molette.app.joursferies.data.db.models.HolidayDb
import kotlinx.coroutines.flow.Flow

interface HolidayRepository {

    fun getHolidaysLocal(zone: Zone, year: Int): Flow<List<HolidayDb>>
    suspend fun getHolidaysRemote(zone: Zone, year: Int)
}