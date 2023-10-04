package com.example.prototiposlan.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.ui.theme.darkgreen
import com.example.prototiposlan.ui.theme.graduateFont

@Composable
fun AlbumScreen(navController: NavController) {
    Scaffold(
        topBar = { GeneralTopBar(title = "Album fotográfico", navController = navController) },
        content = ({ AlbumContent() })
    )
}

@Preview
@Composable
fun AlbumContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Los usuarios pueden subir vivencias y fotografías de su experiencia en el Slan 2023 al album fotográfico, el mejor collage será premiado por los organizadores del evento",
            color = darkgreen,
            fontSize = 18.sp,
            fontFamily = graduateFont,
            modifier = Modifier.padding(4.dp)
        )
        AddRows()
        AddRows()
        AddRows()
    }
}

@Composable
fun AddRows() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        AddBox()
        AddBox()
    }
}

@Composable
fun AddBox() {
    Box(
        modifier = Modifier
            .background(color = Color.LightGray)
            .size(160.dp)
            .border(1.dp, color = Color.Gray)
            .clickable { }, contentAlignment = Alignment.Center
    ) {
        Icon(Icons.Filled.Add, contentDescription = null)
    }
}