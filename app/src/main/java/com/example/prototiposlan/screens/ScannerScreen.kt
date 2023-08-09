package com.example.prototiposlan.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ScannerScreen(navController: NavController){
    Scaffold(
        topBar = { GeneralTopBar(title = "Escáner QR", navController = navController)},
        content = ({ })
    )
}

