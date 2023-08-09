package com.example.prototiposlan.viewModels

import android.icu.util.Calendar
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class DaysViewModel : ViewModel() {
    private fun dayOfTheWeek(): Int {
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

    val userPoints = mutableStateOf(100)

    fun sumUserPoints(){
        userPoints.value + 100
    }

    private val dailyChallengeText1 = mutableStateOf("")
    val dailyChallengeText2 = mutableStateOf("")
    val dailyChallengeText3 = mutableStateOf("")

    fun dailyChallengeText1Func(): MutableState<String> {
        when(dayOfTheWeek()){
            1->{}
        }
        return dailyChallengeText1
    }
}
