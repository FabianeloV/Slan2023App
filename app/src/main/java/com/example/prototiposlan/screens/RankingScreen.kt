package com.example.prototiposlan.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun RankingScreen(navController: NavController) {
    Scaffold(
        topBar = { GeneralTopBar(title = "Ranking", navController = navController) },
        content = ({ Boton() })
    )


}

@Composable
fun Boton() {
    Column(Modifier.fillMaxSize()) {

    }
}


