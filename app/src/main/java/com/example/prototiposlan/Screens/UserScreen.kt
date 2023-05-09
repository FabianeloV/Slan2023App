package com.example.prototiposlan.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.StepsPerDay
import com.example.prototiposlan.ui.theme.darkblue
import com.example.prototiposlan.ui.theme.darkred
import com.example.prototiposlan.R

@Composable
fun UserScreen(navController: NavController) {

    val stepsDays = listOf(
        StepsPerDay.Lunes,
        StepsPerDay.Martes,
        StepsPerDay.Miercoles,
        StepsPerDay.Jueves,
        StepsPerDay.Viernes,
        StepsPerDay.Sabado,
        StepsPerDay.Domingo
    )
    val pasosLunes:Int = StepsPerDay.Lunes.steps
    val pasosMartes:Int = StepsPerDay.Martes.steps
    val pasosMiercoles:Int = StepsPerDay.Miercoles.steps
    val pasosJueves:Int = StepsPerDay.Jueves.steps
    val pasosViernes:Int = StepsPerDay.Viernes.steps
    val pasosSabado:Int = StepsPerDay.Sabado.steps
    val pasosDomingo:Int = StepsPerDay.Domingo.steps

    val pasos = pasosLunes + pasosMartes + pasosMiercoles + pasosJueves + pasosViernes + pasosSabado + pasosDomingo

    Scaffold(
        topBar = { GeneralTopBar(title = "USUARIO", navController = navController) },
        content = ({UserDialog(pasos = pasos.toString(), stepsDays)})
    )
}

@Composable
fun GeneralTopBar(title: String, navController: NavController) {
    TopAppBar(
        title = {
            Text(
                title,
                color = darkblue,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 75.dp)
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Outlined.ArrowBack, contentDescription = "Volver")
            }
        },
        backgroundColor = Color.Transparent,
        elevation = 1.dp
    )
}

@Composable
fun UserDialog(pasos: String, days: List<StepsPerDay>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 35.dp, bottom = 35.dp, start = 25.dp, end = 25.dp)
            .border(
                border = BorderStroke(width = 5.dp, color = darkred),
                shape = RoundedCornerShape(36.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 35.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.usericon), contentDescription = null, modifier = Modifier.size(120.dp))

            Spacer(modifier = Modifier.padding(10.dp))

            Text(text = "NOMBRE", fontSize = 38.sp, color = Color.Black, fontFamily = FontFamily.Monospace)

            Spacer(modifier = Modifier.padding(8.dp))

            Text(text = pasos, fontSize = 42.sp, color = darkblue, fontFamily = FontFamily.Monospace)

            Spacer(modifier = Modifier.padding(2.dp))

            Row {
                Image(
                    painter = painterResource(id = R.drawable.baseline_directions_run_24),
                    contentDescription = "Runner", modifier = Modifier.size(width = 44.dp, height = 44.dp)
                )
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Text(text = "PASOS", fontSize = 28.sp, color = darkblue, fontFamily = FontFamily.Monospace)
            }
            Spacer(modifier = Modifier.padding(20.dp))

            Box(
                modifier = Modifier
                    .border(
                        border = BorderStroke(width = 2.dp, color = Color.Black),
                        shape = RoundedCornerShape(36.dp)
                    )
                    .size(250.dp)
            ){
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp),
                    horizontalAlignment = Alignment.Start) {

                    Text(text = "DIAS", fontFamily = FontFamily.Monospace, fontSize = 28.sp, color = darkred, modifier = Modifier.padding(start = 35.dp))

                    days.forEach{ item ->
                        StepsDays(item = item)
                    }
                }
            }
        }
    }
}

@Composable
fun StepsDays(item: StepsPerDay){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        Text(text = item.day, fontSize = 24.sp, color = Color.Black, fontFamily = FontFamily.Monospace)

        Text(text = item.steps.toString(), fontSize = 24.sp, color = darkblue, fontFamily = FontFamily.Monospace)
    }
}