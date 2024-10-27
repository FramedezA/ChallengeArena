package com.example.challenges.presentation.picker_manager

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Color
import android.util.Log
import com.example.challenges.R
import java.text.SimpleDateFormat
import java.util.Calendar

class PickerManagerImpl: PickerManager {
    @SuppressLint("SimpleDateFormat", "ResourceAsColor")
    override fun showDatePickerDialog(calendar: Calendar,context: Context?, listener: DatePickerDialog.OnDateSetListener) {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val minDateUnix = SimpleDateFormat("dd.MM.yyyy").parse("${day}.${month + 1}.${year}")
        val maxDateUnix = SimpleDateFormat("dd.MM.yyyy").parse("${day + 30}.${month + 1}.${year}")

        context?.let {
            DatePickerDialog(
                it, R.style.Theme_Sport_path_DatePicker,
                listener, year, month, day,
            ).apply {
                if (minDateUnix != null && maxDateUnix != null) {

                    datePicker.minDate = minDateUnix.time
                    datePicker.maxDate = maxDateUnix.time
//                    if (getButton(DatePickerDialog.BUTTON_POSITIVE)==null){
//                        Log.d("mLogButton","я нулл")
//                    }

//                    getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(Color.BLUE)
//                    getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(R.color.black)
                    show()
                }
            }

        }
    }

//    { _, myYear, myMonth, myDay ->
//
//        date = if ((myMonth + 1).toString().length < 2) {
//            "${myDay}.0${myMonth + 1}.${myYear}"
//        } else {
//            "${myDay}.${myMonth + 1}.${myYear}"
//        }
//        viewModel.getPlaceOnline(placeId, date)
//        binding.dateTextView.text = Utils.formattedDate(date)
//
//    }




//    { view, hourOfDay, minute ->
//
//    }
}