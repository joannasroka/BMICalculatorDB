package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.repository.BmiMeasurement

@Database(entities = [BmiMeasurement::class], version = 1, exportSchema = false)
@TypeConverters(UnitTypeConverter::class)
abstract class BmiDatabase : RoomDatabase() {

    abstract val databaseDao: BmiDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: BmiDatabase? = null

        fun getInstance(context: Context): BmiDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BmiDatabase::class.java,
                        "bmi_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}