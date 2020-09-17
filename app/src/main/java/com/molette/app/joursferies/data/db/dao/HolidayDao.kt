package com.molette.app.joursferies.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.molette.app.joursferies.data.db.dao.BaseDao
import com.molette.app.joursferies.data.db.models.HolidayDb
import kotlinx.coroutines.flow.Flow

@Dao
interface HolidayDao: BaseDao<HolidayDb> {

    @Query("SELECT * FROM holidays WHERE holiday_zone = :zone AND holiday_date LIKE :year || '%' ORDER BY holiday_date ASC")
    fun getAll(zone: String, year: String): Flow<List<HolidayDb>>
}