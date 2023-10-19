package com.example.prototiposlan.screens

import android.content.ContentValues
import android.util.Log
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.navigation.NavController
import com.example.prototiposlan.DataStore
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.Shapes
import com.example.prototiposlan.ui.theme.darkgreen
import com.example.prototiposlan.ui.theme.darkorange
import com.example.prototiposlan.ui.theme.gold
import com.example.prototiposlan.ui.theme.graduateFont
import com.example.prototiposlan.viewModels.DaysViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

@Composable
fun ChallengeScreen(
    navController: NavController,
    daysViewModel: DaysViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Scaffold(
        topBar = { GeneralTopBar(title = "Reto del día", navController = navController) },
        content = ({ ChallengeBody(daysViewModel) })
    )
}


@Composable
fun ChallengeBody(daysViewModel: DaysViewModel) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = daysViewModel.getTranslatedDay(),
            fontSize = 36.sp,
            fontFamily = graduateFont,
            modifier = Modifier.padding(top = 30.dp),
            color = darkgreen
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(35.dp)
                .border(shape = Shapes.small, border = BorderStroke(2.dp, color = darkgreen))
        ) {
            ChallengeBox(daysViewModel)
        }
    }
}

@Composable
fun ChallengeBox(daysViewModel: DaysViewModel) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val dataStore = DataStore(context)

    val challengeState = booleanPreferencesKey(daysViewModel.getTranslatedDay())
    val savedChallengeState =
        dataStore.getPlantState(challengeState).collectAsState(initial = false)

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Challenge(daysViewModel.getChallenge()[0], R.drawable.baseline_fitness_center_24)

        Box(
            modifier = Modifier
                .height(2.dp)
                .width(200.dp)
                .background(color = darkgreen)
                .padding(top = 20.dp)
        )

        InvertedChallenge(
            challenge = daysViewModel.getChallenge()[1],
            icon = R.drawable.baseline_monitor_heart_24
        )

        Box(
            modifier = Modifier
                .height(2.dp)
                .width(200.dp)
                .background(color = darkgreen)
                .padding(top = 20.dp)
        )

        Challenge(
            challenge = daysViewModel.getChallenge()[2],
            icon = R.drawable.baseline_directions_run_24
        )

        Box(
            modifier = Modifier
                .height(2.dp)
                .width(250.dp)
                .background(color = darkorange)
                .padding(top = 40.dp)
        )

        PointsButton(
            {
                scope.launch { dataStore.savePlantState(challengeState) }
                daysViewModel.sumTwentyPoints()
            },
            savedChallengeState.value!!
        )
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
fun PointsButton(click: () -> Unit, enabled: Boolean) {
    OutlinedButton(
        onClick = { click() },
        colors = ButtonDefaults.buttonColors(backgroundColor = gold),
        shape = CircleShape,
        modifier = Modifier.padding(top = 30.dp),
        enabled = !enabled
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