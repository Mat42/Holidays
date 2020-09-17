package com.molette.app.joursferies.data.repositories

import android.util.Log
import com.molette.app.joursferies.core.common.enums.Zone
import com.molette.app.joursferies.data.db.AppDatabase
import com.molette.app.joursferies.data.db.models.HolidayDb
import com.molette.app.joursferies.data.network.GouvAPI
import com.molette.app.joursferies.domain.repositories.HolidayRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class HolidayRepositoryImpl(private val localDataSource: AppDatabase, private val remoteDataSource: GouvAPI): HolidayRepository {

    override fun getHolidaysLocal(zone: Zone, year: Int): Flow<List<HolidayDb>> {
        return localDataSource.holidayDao.getAll(zone = zone.value, year = year.toString())
    }

    override suspend fun getHolidaysRemote(zone: Zone, year: Int) {
        withContext(Dispatchers.IO){
            Log.d("getHolidaysRemote", zone.value)
            Log.d("getHolidaysRemote", year.toString())
            val holidaysRemote = remoteDataSource.getHolidays(zone = zone.value, year = year.toString())
            val holidaysDb = holidaysRemote.map { HolidayDb(date = it.key, name = it.value, zone = zone.value) }
            localDataSource.holidayDao.insertAll(holidaysDb)
        }
    }
}