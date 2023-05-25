package com.example.prototiposlan

sealed class StepsPerDay(val day:String, val steps:Int){

    object Lunes :StepsPerDay("LUNES", 6810)
    object Martes :StepsPerDay("MARTES", 7204)
    object Miercoles :StepsPerDay("MIERCOLES", 8290)
    object Jueves :StepsPerDay("JUEVES", 633)
    object Viernes :StepsPerDay("VIERNES", 0)
    object Sabado :StepsPerDay("SABADO", 0)
    object Domingo :StepsPerDay("DOMINGO", 0)
}
