package com.example.prototiposlan.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.R
import com.example.prototiposlan.viewModels.DaysViewModel
import com.example.prototiposlan.ui.theme.Shapes
import com.example.prototiposlan.ui.theme.darkblue
import com.example.prototiposlan.ui.theme.darkred
import com.example.prototiposlan.ui.theme.graduateFont

@Composable
fun UserScreen(navController: NavController, Steps: Int,viewModel: DaysViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    Scaffold(
        topBar = { GeneralTopBar(title = "USUARIO", navController = navController) },
        content = ({ UserContent(viewModel, Steps) })
    )
}
@Composable
fun GeneralTopBar(title: String, navController: NavController) {
    TopAppBar(
        title = {
            Row(horizontalArrangement = Arrangement.Center) {
                Text(
                    title,
                    color = darkblue,
                    fontSize = 25.sp,
                    fontFamily = graduateFont
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Outlined.ArrowBack, contentDescription = "Volver")
            }
        },
        backgroundColor = Color.Transparent,
        elevation = 1.dp,
    )
}
@Composable
fun UserContent(viewModel: DaysViewModel, Steps:Int) {
    val steps by remember { mutableStateOf(Steps) }
    val calories by remember { mutableStateOf(steps*0.04) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp)
            .border(shape = Shapes.small, border = BorderStroke(2.dp, color = darkblue))
    ) {
        Image(
            painter = painterResource(id = R.drawable.usericon),
            contentDescription = "User icon",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.padding(25.dp))

        GenericUserText(text = "Fabian Verdesoto", fontSize = 28, color = Color.Black)

        Spacer(modifier = Modifier.padding(16.dp))

        GenericUserNumber(number = steps, fontSize = 44, color = darkred)

        RowWithIcon()

        Spacer(modifier = Modifier.padding(20.dp))

        GenericUserNumber(number = calories.toInt(), fontSize = 44, color = darkred)

        GenericUserText(text = "cal quemadas", fontSize = 32, color = darkblue)

        Spacer(modifier = Modifier.padding(20.dp))

        GenericUserNumber(number = 0, fontSize = 44, color = darkred)

        GenericUserText(text = "Puntos", fontSize = 32, color = darkblue)

    }
}
@Composable
fun GenericUserText(text: String, fontSize: Int, color: Color) {
    Text(text = text, fontSize = fontSize.sp, color = color, fontFamily = graduateFont)
}

@Composable
fun GenericUserNumber(number:Int, fontSize: Int, color: Color){
    Text(text = number.toString(), fontSize = fontSize.sp, color = color, fontFamily = graduateFont)
}
@Composable
fun RowWithIcon() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(id = R.drawable.baseline_directions_run_24),
            contentDescription = "Runner",
            modifier = Modifier.size(36.dp)
        )
        GenericUserText(text = "Pasos de hoy", fontSize = 32, color = darkblue)
    }
}