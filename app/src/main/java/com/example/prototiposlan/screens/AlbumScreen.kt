package com.example.prototiposlan.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AlbumScreen(navController: NavController){
    Scaffold(
        topBar = { GeneralTopBar(title = "Album fotográfico", navController = navController)},
        content = ({})
    )
}