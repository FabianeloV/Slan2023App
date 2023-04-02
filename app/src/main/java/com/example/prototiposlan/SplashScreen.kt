package com.example.prototiposlan.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.prototiposlan.R
import kotlinx.coroutines.delay


@Composable
fun Splash(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.popBackStack()
        navController.navigate("LoginScreen")
    }

    SplashImage()
}

@Composable
fun SplashImage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Image(
            painter = painterResource(id = R.drawable.escudo),
            contentDescription = "Escudo",
            modifier = Modifier.size(width = 250.dp, height = 250.dp)
        )

        Spacer(modifier = Modifier.padding(top = 20.dp))

        Image(painter = painterResource(id = R.drawable.fonotipo), contentDescription = "Fonotipo")
    }
}