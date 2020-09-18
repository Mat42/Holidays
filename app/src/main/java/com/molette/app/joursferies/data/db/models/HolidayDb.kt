package com.molette.app.joursferies.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.molette.app.joursferies.domain.models.Holiday
import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Entity(tableName = "holidays", primaryKeys = ["holiday_date", "holiday_zone"])
@Serializable
data class HolidayDb(
    @ColumnInfo(name = "holiday_date")
    val date: String,
    @ColumnInfo(name = "holiday_name")
    val name: String,
    @ColumnInfo(name = "holiday_zone")
    val zone: String
) {
}

fun HolidayDb.toHoliday(): Holiday{
    val formatter = SimpleDateFormat("yyyy-MM-dd")
    val newDate = formatter.parse(date)

    return Holiday(
        date = newDate,
        name = name
    )
}