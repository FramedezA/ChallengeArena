package com.example.challenges

import android.util.Log

import java.lang.IndexOutOfBoundsException
import java.util.Calendar

object Utils {



    fun formattedDate(date: String): String {
        val dateSplit = date.split('.').map { it.toInt() }
        val month = when (dateSplit[1]) {
            1 -> "Января"
            2 -> "Февраля"
            3 -> "Марта"
            4 -> "Апреля"
            5 -> "Мая"
            6 -> "Июня"
            7 -> "Июля"
            8 -> "Августа"
            9 -> "Сентября"
            10 -> "Октября"
            11 -> "Ноября"
            12 -> "Декабря"
            else -> "Декабря"
        }
        return "${dateSplit[0]} $month"
    }
    fun getTodayDate(): String {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        if ((month+1).toString().length<2){
            return "${day}.0${month + 1}.${year}"
        }
        return "${day}.${month + 1}.${year}"
    }

    fun convertDate(day:Int,month:Int,year:Int):String= if (month + 1 < 10) {
        "${year}-0${month + 1}-${day}"
    } else {
        "${year}-${month + 1}-${day}"
    }

}

fun mLog(tag:String,msg:String){
    Log.d("mLog$tag",msg)
}

