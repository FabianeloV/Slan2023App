@file:Suppress("NAME_SHADOWING")

package com.example.prototiposlan.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.Shapes
import com.example.prototiposlan.ui.theme.darkblue
import com.example.prototiposlan.ui.theme.darkred
import com.example.prototiposlan.ui.theme.graduateFont
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

@Composable
fun UserScreen(navController: NavController, steps: Int) {
    val userPoints = remember { mutableStateOf(0) }
    val userNickname = remember { mutableStateOf("") }
    val auth: FirebaseAuth = Firebase.auth
    val userId = auth.currentUser?.uid
    val db = FirebaseFirestore.getInstance()
    val docRef = db.collection("users").document(userId.toString())

    docRef.get().addOnSuccessListener { documentSnapshot ->
        if (documentSnapshot.exists()) {
            val fieldValue = documentSnapshot.getString("nickname")
            if (fieldValue != null) {
                // Do something with the field value
                userNickname.value = fieldValue.toString()
            } else {
                // Handle the case where the field doesn't exist or is null
                userNickname.value = "Usuario"
            }
        } else {
            // Handle the case where the document doesn't exist
            userNickname.value = "Usuario"
        }
    }
        .addOnFailureListener { exception ->
            // Handle any errors that occurred during the retrieval
            println("Error getting document: $exception")
        }

    docRef.get().addOnSuccessListener { documentSnapshot ->
        if (documentSnapshot.exists()) {
            val fieldValue = documentSnapshot.getLong("points")?.toInt()
            if (fieldValue != null) {
                // Do something with the field value
                userPoints.value = fieldValue
            } else {
                // Handle the case where the field doesn't exist or is null
                userPoints.value = 1
            }
        } else {
            // Handle the case where the document doesn't exist
            userPoints.value = 3
        }
    }
        .addOnFailureListener { exception ->
            // Handle any errors that occurred during the retrieval
            Log.d("points", "error $exception")
        }

    Scaffold(
        topBar = { GeneralTopBar(title = "USUARIO", navController = navController) },
        content = ({ UserContent(steps, userPoints.value, userNickname.value) })
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
fun UserContent(Steps: Int, points: Int, nickName: String) {
    val steps by remember { mutableStateOf(Steps) }
    val calories by remember { mutableStateOf(steps * 0.04) }
    val points by remember { mutableStateOf(points) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp)
            .border(shape = Shapes.small, border = BorderStroke(2.dp, color = darkblue))
    ) {
        Image(
            painter = painterResource(id = R.drawable.foto),
            contentDescription = "User icon",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .border(2.dp, color = darkblue)
        )
        Spacer(modifier = Modifier.padding(25.dp))

        GenericUserText(text = nickName, fontSize = 28, color = Color.Black)

        Spacer(modifier = Modifier.padding(16.dp))

        GenericUserNumber(number = steps, fontSize = 44, color = darkred)

        RowWithIcon()

        Spacer(modifier = Modifier.padding(20.dp))

        GenericUserNumber(number = calories.toInt(), fontSize = 44, color = darkred)

        GenericUserText(text = "cal quemadas", fontSize = 32, color = darkblue)

        Spacer(modifier = Modifier.padding(20.dp))

        GenericUserNumber(number = points, fontSize = 44, color = darkred)

        GenericUserText(text = "Puntos", fontSize = 32, color = darkblue)

    }
}

@Composable
fun GenericUserText(text: String, fontSize: Int, color: Color) {
    Text(text = text, fontSize = fontSize.sp, color = color, fontFamily = graduateFont)
}

@Composable
fun GenericUserNumber(number: Int, fontSize: Int, color: Color) {
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