package com.example.prototiposlan.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import com.example.prototiposlan.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Splash(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.popBackStack()
        navController.navigate("LoginScreen")

        if(FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()){
            navController.navigate("LoginScreen")
        } else{
            navController.navigate("HomeScreen")
        }
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
            painter = painterResource(id = R.drawable.slanlogo),
            contentDescription = "Escudo",
            modifier = Modifier.size(width = 350.dp, height = 350.dp)
        )
    }
}