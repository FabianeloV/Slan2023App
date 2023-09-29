package com.example.prototiposlan.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.R
import com.example.prototiposlan.Textos
import com.example.prototiposlan.ui.theme.Shapes
import com.example.prototiposlan.ui.theme.darkblue
import com.example.prototiposlan.ui.theme.darkred
import com.example.prototiposlan.ui.theme.gold
import com.example.prototiposlan.ui.theme.graduateFont

@Composable
fun ChallengeScreen(
    navController: NavController
) {
    Scaffold(
        topBar = { GeneralTopBar(title = "Reto del día", navController = navController) },
        content = ({ ChallengeBody() })
    )
}

@Preview
@Composable
fun ChallengeBody() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Miércoles",
            fontSize = 36.sp,
            fontFamily = graduateFont,
            modifier = Modifier.padding(top = 30.dp),
            color = darkblue
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(35.dp)
                .border(shape = Shapes.small, border = BorderStroke(2.dp, color = darkblue))
        ) {
            ChallengeBox()       }
    }
}

@Composable
fun ChallengeBox() {
    val challenges = Textos()
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Challenge(challenges.mondayChallenge1, R.drawable.baseline_fitness_center_24)

        Box(
            modifier = Modifier
                .height(2.dp)
                .width(200.dp)
                .background(color = darkblue)
                .padding(top = 20.dp)
        )

        InvertedChallenge(challenge = challenges.mondayChallenge2, icon = R.drawable.baseline_monitor_heart_24)

        Box(
            modifier = Modifier
                .height(2.dp)
                .width(200.dp)
                .background(color = darkblue)
                .padding(top = 20.dp)
        )

        Challenge(challenge = challenges.mondayChallenge3, icon = R.drawable.baseline_directions_run_24)

        Box(
            modifier = Modifier
                .height(2.dp)
                .width(250.dp)
                .background(color = darkred)
                .padding(top = 40.dp)
        )

        PointsButton()
    }
}

@Composable
fun Challenge(challenge: String, icon: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = challenge,
            fontSize = 24.sp,
            fontFamily = graduateFont,
            modifier = Modifier.padding(top = 20.dp)
        )
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 20.dp)
                .size(84.dp)
        )
    }
}

@Composable
fun InvertedChallenge(challenge: String, icon: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 20.dp)
                .size(84.dp)
        )
        Text(
            text = challenge,
            fontSize = 24.sp,
            fontFamily = graduateFont,
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}

@Composable
fun PointsButton() {
    val colorBut by remember { mutableStateOf(gold) }
    OutlinedButton(
        onClick = {  },
        colors = ButtonDefaults.buttonColors(backgroundColor = colorBut),
        shape = CircleShape,
        modifier = Modifier.padding(top = 30.dp)
    ) {
        Text(
            text = "COMPLETADO",
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = graduateFont
        )

        Spacer(modifier = Modifier.padding(5.dp))

        Icon(imageVector = Icons.Outlined.Done, contentDescription = null)
    }
}