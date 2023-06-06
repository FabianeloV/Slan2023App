package com.example.prototiposlan.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ChallengeScreen(navController: NavController) {
    Scaffold(
        topBar = { GeneralTopBar(title = "Reto del dia", navController = navController) },
        content = ({ ChallengeBody()})
    )
}

@Composable
fun ChallengeBody(){
    Column(modifier = Modifier.fillMaxSize()) {

    }
}
