package com.example.prototiposlan

import android.icu.util.Calendar
import androidx.lifecycle.ViewModel

class StepsPerDay : ViewModel() {
    fun dayOfTheWeek(): Int {
        val calendar = Calendar.getInstance()
        return when (calendar.get(Calendar.DAY_OF_WEEK)) {
            Calendar.SUNDAY -> 1
            Calendar.MONDAY -> 2
            Calendar.TUESDAY -> 3
            Calendar.WEDNESDAY -> 4
            Calendar.THURSDAY -> 5
            Calendar.FRIDAY -> 6
            Calendar.SATURDAY -> 7
            else -> 0
        }
    }
}
