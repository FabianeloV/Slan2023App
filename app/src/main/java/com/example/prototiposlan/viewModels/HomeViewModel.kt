package com.example.prototiposlan.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.prototiposlan.screens.LatMenuScreens
import com.example.prototiposlan.screens.Schedule

class HomeViewModel : ViewModel() {

    val latMenuItem = listOf(
        LatMenuScreens.Ranking,
        LatMenuScreens.Reto,
        LatMenuScreens.Muro,
        LatMenuScreens.Mapa,
        LatMenuScreens.Flora,
        LatMenuScreens.Album
    )

    private val eventList = listOf(
        Schedule.T2,
        Schedule.T3,
        Schedule.T1,
        Schedule.T5,
        Schedule.T6,
        Schedule.T4,
        Schedule.Conf,
        Schedule.Music,
        Schedule.S1,
        Schedule.S2,
        Schedule.S3,
        Schedule.S16,
        Schedule.S4,
        Schedule.S6,
        Schedule.S7,
        Schedule.CM1,
        Schedule.CM2,
        Schedule.MT1,
        Schedule.S8,
        Schedule.S9,
        Schedule.S10,
        Schedule.S11,
        Schedule.S12,
        Schedule.S23,
        Schedule.S13,
        Schedule.CM3,
        Schedule.PCO1,
        Schedule.PCO2,
        Schedule.PCO3,
        Schedule.PCO4,
        Schedule.PCO5,
        Schedule.PCO6,
        Schedule.PCO7,
        Schedule.PCO8,
        Schedule.MT2,
        Schedule.S14,
        Schedule.S15,
        Schedule.S71,
        Schedule.S66,
        Schedule.S17,
        Schedule.S18,
        Schedule.S19,
        Schedule.E1,
        Schedule.YOGA,
        Schedule.MT8,
        Schedule.S20,
        Schedule.S21,
        Schedule.S22,
        Schedule.S68,
        Schedule.S24,
        Schedule.S25,
        Schedule.S26,
        Schedule.CM5,
        Schedule.CM6,
        Schedule.MT3,
        Schedule.S28,
        Schedule.S29,
        Schedule.S30,
        Schedule.S65,
        Schedule.S31,
        Schedule.S32,
        Schedule.CM7,
        Schedule.CM8,
        Schedule.PCO9,
        Schedule.PCO10,
        Schedule.PCO11,
        Schedule.PCO12,
        Schedule.PCO13,
        Schedule.PCO14,
        Schedule.PCO15,
        Schedule.PCO16,
        Schedule.MT4,
        Schedule.S33,
        Schedule.S70,
        Schedule.S35,
        Schedule.S36,
        Schedule.S37,
        Schedule.S38,
        Schedule.S69,
        Schedule.E2,
        Schedule.AFF,
        Schedule.MT5,
        Schedule.S39,
        Schedule.S40,
        Schedule.S41,
        Schedule.S43,
        Schedule.S44,
        Schedule.S45,
        Schedule.CM10,
        Schedule.CM11,
        Schedule.MTC10,
        Schedule.S46,
        Schedule.S47,
        Schedule.S48,
        Schedule.S49,
        Schedule.S50,
        Schedule.S51,
        Schedule.CM12,
        Schedule.CM13,
        Schedule.PCO17,
        Schedule.PCO18,
        Schedule.PCO19,
        Schedule.PCO20,
        Schedule.PCO21,
        Schedule.PCO22,
        Schedule.PCO23,
        Schedule.PCO24,
        Schedule.MT6,
        Schedule.S53,
        Schedule.S59,
        Schedule.S55,
        Schedule.S56,
        Schedule.S57,
        Schedule.S58,
        Schedule.S54,
        Schedule.MT7
    )

    val daysSchedule = listOf("21 oct", "22 oct", "23 oct", "24 oct", "25 oct")
    var selectedDay by mutableStateOf(daysSchedule.first())

    private val firstDayEvents = eventList.subList(0, 3)
    private val secondDayEvents = eventList.subList(3, 7)
    private val thirdDayEvents = eventList.subList(7, 43)
    private val fourthDayEvents = eventList.subList(43, 80)
    private val fifthDayEvents = eventList.subList(80, 115)

    fun getEventsList(): List<Schedule> {
        return when (selectedDay) {
            "21 oct" -> firstDayEvents
            "22 oct" -> secondDayEvents
            "23 oct" -> thirdDayEvents
            "24 oct" -> fourthDayEvents
            "25 oct" -> fifthDayEvents
            else -> {
                firstDayEvents
            }
        }
    }

    fun getDateText(): String {
        return when (selectedDay) {
            "21 oct" -> "21 de octubre"
            "22 oct" -> "22 de octubre"
            "23 oct" -> "23 de octubre"
            "24 oct" -> "24 de octubre"
            "25 oct" -> "25 de octubre"
            else -> {
                "21 de octubre"
            }
        }
    }
}