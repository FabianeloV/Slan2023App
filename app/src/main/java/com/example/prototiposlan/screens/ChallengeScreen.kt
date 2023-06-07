package com.example.prototiposlan.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.DaysViewModel
import com.example.prototiposlan.ui.theme.Shapes
import com.example.prototiposlan.ui.theme.darkblue
import com.example.prototiposlan.ui.theme.graduateFont

@Composable
fun ChallengeScreen(
    navController: NavController
) {
    Scaffold(
        topBar = { GeneralTopBar(title = "Reto del dia", navController = navController) },
        content = ({ ChallengeBody() })
    )
}

@Preview
@Composable
fun ChallengeBody() {
    val viewModel: DaysViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp)
            .border(shape = Shapes.small, border = BorderStroke(2.dp, color = darkblue))
    ) {
        ChallengeBox(viewModel)
    }
}

@Composable
fun ChallengeBox(viewModel: DaysViewModel) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

    }
}