package com.molette.app.joursferies.data.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.molette.app.joursferies.data.db.dao.HolidayDao
import com.molette.app.joursferies.data.db.models.HolidayDb
import kotlinx.serialization.ImplicitReflectionSerializer

@OptIn(ImplicitReflectionSerializer::class)
@Database(entities = [HolidayDb::class],
    version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract val holidayDao: HolidayDao

    companion object{
        private const val DB_NAME = "holidays_db"

        fun buildDb(context: Context): AppDatabase{
            return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .addCallback(object : Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Log.d("buildDb", "Db created")
                    }
                })
                .build()
        }
    }
}