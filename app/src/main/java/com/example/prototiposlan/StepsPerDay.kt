package com.example.prototiposlan

sealed class StepsPerDay(val day:String, val steps:Int){

    object Lunes :StepsPerDay("LUNES", 681)
    object Martes :StepsPerDay("MARTES", 1204)
    object Miercoles :StepsPerDay("MIERCOLES", 790)
    object Jueves :StepsPerDay("JUEVES", 2033)
    object Viernes :StepsPerDay("VIERNES", 891)
    object Sabado :StepsPerDay("SABADO", 802)
    object Domingo :StepsPerDay("DOMINGO", 603)
}
