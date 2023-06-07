package com.example.prototiposlan

import android.icu.util.Calendar
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class DaysViewModel : ViewModel() {
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
    val stepCounter = mutableStateOf(0)

    val DailyChallengeText1 = mutableStateOf("")
    val DailyChallengeText2 = mutableStateOf("")
    val DailyChallengeText3 = mutableStateOf("")

    fun DailyChallengeText1Func(): MutableState<String> {
        when(dayOfTheWeek()){
            1->{}
        }
        return DailyChallengeText1
    }
}
