package com.example.prototiposlan.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.ui.theme.darkred

@Composable
fun RegisterScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(top = 85.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

            RegisterTitle()
        Spacer(modifier = Modifier.padding(25.dp))
            Mail(){ Icon(imageVector = Icons.Outlined.AccountBox, contentDescription = null) }
        Spacer(modifier = Modifier.padding(25.dp))
            Password("Contraseña"){ Icon(imageVector = Icons.Outlined.Lock, contentDescription = null)}
        Spacer(modifier = Modifier.padding(25.dp))
            Password("Repetir contraseña"){ Icon(imageVector = Icons.Outlined.Lock, contentDescription = null)}
        Spacer(modifier = Modifier.padding(25.dp))
            GoogleRegisterLogo()
        Spacer(modifier = Modifier.padding(25.dp))
            LoginButton(text = "CREAR CUENTA", color = darkred, navController)
    }
}

@Composable
fun RegisterTitle(){
    Text(text = "Crear una cuenta", color = darkred, fontSize = 40.sp, fontFamily = FontFamily.Serif)
}


