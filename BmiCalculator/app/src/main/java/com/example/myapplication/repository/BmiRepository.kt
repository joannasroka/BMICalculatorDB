package com.example.myapplication.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.database.BmiDatabaseDao


class BmiRepository(private val bmiDatabaseDao: BmiDatabaseDao) {

    fun readData(): LiveData<List<BmiMeasurement>> {
        return bmiDatabaseDao.getTenLatest()
    }

    fun saveDate(bmiMeasurement: BmiMeasurement) {
        bmiDatabaseDao.insert(bmiMeasurement)
    }

}