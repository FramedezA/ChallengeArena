package com.example.challenges.presentation.picker_manager

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import java.util.Calendar

interface PickerManager {
    fun showDatePickerDialog(calendar: Calendar,context: Context?, listener: DatePickerDialog.OnDateSetListener)

}