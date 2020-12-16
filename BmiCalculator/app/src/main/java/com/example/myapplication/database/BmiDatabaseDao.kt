package com.example.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.repository.BmiMeasurement

@Dao
interface BmiDatabaseDao {

    @Insert
    fun insert(measurement: BmiMeasurement)

    @Update
    fun update(measurement: BmiMeasurement)

    @Query("SELECT * FROM bmi_measurement_table ORDER BY measurementId DESC")
    fun getAll(): LiveData<List<BmiMeasurement>>

    @Query("SELECT * FROM bmi_measurement_table ORDER BY measurementId DESC LIMIT 10")
    fun getTenLatest(): LiveData<List<BmiMeasurement>>

    @Query("SELECT * from bmi_measurement_table WHERE measurementId = :key")
    fun get(key: Long): BmiMeasurement?

    @Query("DELETE FROM bmi_measurement_table")
    fun clear()


}