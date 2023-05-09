package com.example.prototiposlan.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.ui.theme.darkblue

@Composable
fun PresentationsScreen(navController: NavController){
    Scaffold (
        topBar = { GeneralTopBar(title = "PRESENTACIONES", navController = navController)},
        content = ({ PresentationContent()})
    )
}

@Composable
fun PresentationContent(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 15.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        UploadButton()
    }
}

@Composable
fun UploadButton(){
    OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.background(darkblue)) {
        Text(text = "SUBIR PONENCIA", fontFamily = FontFamily.Serif, fontSize = 15.sp)
    }
}



