package com.example.myapplication.repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.calculation.BmiCategory
import com.example.myapplication.calculation.BmiUnit

@Entity(tableName = "bmi_measurement_table")
data class BmiMeasurement(
    @ColumnInfo(name = "bmi")
    val bmiResult: Double,

    @ColumnInfo(name = "weight")
    val weight: Double,

    @ColumnInfo(name = "height")
    val height: Double,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "unit")
    val bmiUnit: BmiUnit,

    @ColumnInfo(name = "category")
    val bmiCategory: BmiCategory,

    @PrimaryKey(autoGenerate = true)
    var measurementId: Long = 0L
)