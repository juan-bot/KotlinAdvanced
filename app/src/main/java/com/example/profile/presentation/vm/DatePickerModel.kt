package com.example.profile.presentation.vm

import android.app.DatePickerDialog
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class DatePickerModel : ViewModel() {
    private var year1 = ""
    private var month1 = ""
    private var day1 = ""
    private var date = ""
    private var dateModel: MutableLiveData<String> = MutableLiveData()
    fun DatePickerShow(ctx: Context) {
        val calendar = Calendar.getInstance()
        var year = calendar.get(Calendar.YEAR) - 18
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePicker = DatePickerDialog(
            ctx,
            { datePicker, y, m, d ->
                year1 = y.toString()
                month1 = m.toString()
                day1 = d.toString()
                dateModel.postValue("$d/$m/$y")
                println("Date: $d - $m - $y")
            },
            year,
            month,
            day
        )
        calendar.set(Calendar.YEAR, year)
        datePicker.datePicker.maxDate = calendar.timeInMillis

        calendar.set(Calendar.YEAR, 1982)
        datePicker.datePicker.minDate = calendar.timeInMillis

        datePicker.show()
    }
}
