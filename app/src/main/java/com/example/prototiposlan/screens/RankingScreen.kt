package com.example.prototiposlan.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun RankingScreen(navController: NavController){
    Scaffold(
        topBar = { GeneralTopBar(title = "Ranking", navController = navController)},
        content = ({})
    )
}