package com.example.prototiposlan.screens

import androidx.compose.runtime.MutableState
import com.example.prototiposlan.viewModels.HomeViewModel


val homeViewModel = HomeViewModel()
sealed class Schedule(
    val event: String,
    val ubication: String,
    val hour: String,
    val description: String,
    var showDialog:MutableState<Boolean>,
) {
    object T2 : Schedule(
        "El Código Internacional de Comercialización de Sucedáneos de Leche Materna (CICSLM), su impacto en las políticas de Lactancia materna y Aplicación del Conjunto de Instrumentos para su Monitoreo",
        "Sala 3 Arquitectura",
        "8:00 a 13:00",
        "este es una prueba 1",
        homeViewModel.showDialog,
    )

    object T3 : Schedule(
        "Métodos cualitativos en investigaciones nutricionales",
        "Sala 4 Hugo Ordóñez",
        "8:15 a 12:15",
        "este es una prueba 2",
        homeViewModel.showDialog1,
        )

    object T1 : Schedule(
        "La aplicación de investigación participativa en nutrición",
        "Sala 2 Aula Magna Mario Vintimilla ",
        "9:00 a 13:00",
        "este es una prueba 3",
        homeViewModel.showDialog3,
    )
}