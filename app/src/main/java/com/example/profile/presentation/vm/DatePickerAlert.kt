/*
 * DatePickerAlert.kt
 * Android Kotlin Juan
 * Created by Juan Pablo on 01/09/2022, 16:08:09
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.example.profile.presentation.vm

import android.app.DatePickerDialog
import android.content.Context
import android.widget.EditText
import java.util.*

class DatePickerAlert(private val ctx: Context) {
    private var year1 = ""
    private var month1 = ""
    private var day1 = ""
    private var date = ""
    fun show(edit: EditText) {
        val calendar = Calendar.getInstance()
        var year = calendar.get(Calendar.YEAR) - 18
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePicker = DatePickerDialog(
            ctx,
            { datePicker, y, m, d ->
                year1 = y.toString()
                month1 = (m-1).toString()
                day1 = d.toString()
                edit.setText("$day1/$month1/$year1")
                println("Date: $day1 - $month1 - $year1")
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
