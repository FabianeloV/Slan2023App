package com.example.prototiposlan.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.graduateFont

@Composable
fun PlantsScreen(navController: NavController) {
    Scaffold(
        topBar = { GeneralTopBar(title = "Flora y fauna", navController = navController) },
        content = ({ PlantsContent() })
    )
}

@Composable
fun PlantsContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) { PlantCard() }
}

@Preview
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PlantCard() {
    Card(elevation = 6.dp, modifier = Modifier.padding(top = 5.dp), onClick = {}) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(verticalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = "Manzanilla", fontSize = 16.sp, fontFamily = graduateFont)

                    Text(
                        text = "Chamaemelum nobile",
                        fontFamily = graduateFont,
                        color = Color.DarkGray
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = { Text(text = "Ingresar código") },
                            modifier = Modifier.size(height = 60.dp, width = 150.dp),
                            shape = CircleShape
                        )
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(start = 6.dp)
                                .border(width = 1.dp, color = Color.Black, shape = CircleShape)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.ArrowForward,
                                contentDescription = null
                            )
                        }
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.foto),
                    contentDescription = "Flower",
                    modifier = Modifier
                        .size(96.dp)
                        .clip(
                            CircleShape
                        )
                )
            }
        }
    }
    AnimatedVisibility(visible = false) {
        Text(
            text = "Se emplean las flores y hojas para tratar un gran número de afecciones: trastornos digestivos (dolor de estómago, indigestión, dispepsia, cólicos, diarreas), afecciones renales y de la vejiga, dolores menstruales.",
            modifier = Modifier.padding(top = 5.dp)
        )
    }
}