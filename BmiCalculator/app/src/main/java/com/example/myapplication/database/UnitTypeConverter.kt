package com.example.myapplication.database

import androidx.room.TypeConverter
import com.example.myapplication.calculation.BmiCategory
import com.example.myapplication.calculation.BmiUnit
import java.util.*

class UnitTypeConverter {

    @TypeConverter
    fun fromUnitToString(bmiUnit: BmiUnit?): String? {
        return bmiUnit?.name
    }

    @TypeConverter
    fun fromStringToUnit(bmiString: String?): BmiUnit? = bmiString?.let {
        BmiUnit.valueOf(it)
    }

    @TypeConverter
    fun fromCategoryToString(bmiCategory: BmiCategory?): String? {
        return bmiCategory?.name
    }

    @TypeConverter
    fun fromStringToCategory(categoryString: String?): BmiCategory? = categoryString?.let {
        BmiCategory.valueOf(it)
    }

    @TypeConverter
    fun fromDateToString(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromStringToDate(dateLong: Long?): Date? = dateLong?.let {
        Date(it)
    }

}