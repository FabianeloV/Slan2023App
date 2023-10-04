package com.example.prototiposlan.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.prototiposlan.ui.theme.darkgreen
import com.example.prototiposlan.ui.theme.darkorange
import com.example.prototiposlan.ui.theme.graduateFont
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

@Composable
fun UserScreen(navController: NavController, steps: Int) {
    val userNickname = remember { mutableStateOf("") }
    val auth: FirebaseAuth = Firebase.auth
    val userId = auth.currentUser?.uid
    val db = FirebaseFirestore.getInstance()
    val docRef = db.collection("users").document(userId.toString())

    docRef.get().addOnSuccessListener { documentSnapshot ->
        if (documentSnapshot.exists()) {

            val fieldValue = documentSnapshot.getString("nickname")
            if (fieldValue != null) {
                userNickname.value = fieldValue.toString()
            } else {
                userNickname.value = "Usuario"
            }
        }
    }
        .addOnFailureListener { exception ->
            println("Error getting document: $exception")
        }

    Scaffold(
        topBar = { GeneralTopBar(title = "USUARIO", navController = navController) },
        content = ({ UserContent(steps, userNickname.value) })
    )
}

@Composable
fun GeneralTopBar(title: String, navController: NavController) {
    TopAppBar(
        title = {
            Row(horizontalArrangement = Arrangement.Center) {
                Text(
                    title,
                    color = darkgreen,
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
fun UserContent(Steps: Int, nickName: String) {
    val steps by remember { mutableStateOf(Steps) }
    val calories by remember { mutableStateOf(steps * 0.04) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp)
            .border(shape = Shapes.small, border = BorderStroke(2.dp, color = darkgreen))
    ) {
        Image(
            painter = painterResource(id = R.drawable.foto),
            contentDescription = "User icon",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .border(2.dp, color = darkgreen)
        )
        Spacer(modifier = Modifier.padding(25.dp))

        GenericUserText(text = nickName, fontSize = 28, color = Color.Black)

        Spacer(modifier = Modifier.padding(16.dp))

        GenericUserNumber(number = steps, fontSize = 44, color = darkorange)

        RowWithIcon()

        Spacer(modifier = Modifier.padding(20.dp))

        GenericUserNumber(number = calories.toInt(), fontSize = 44, color = darkorange)

        GenericUserText(text = "cal quemadas", fontSize = 32, color = darkgreen)

        Spacer(modifier = Modifier.padding(20.dp))

        Points()

        GenericUserText(text = "Puntos", fontSize = 32, color = darkgreen)

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
        GenericUserText(text = "Pasos de hoy", fontSize = 32, color = darkgreen)
    }
}

@Composable
fun Points(){
    var userPoints by remember { mutableStateOf(6) }

    val auth: FirebaseAuth = Firebase.auth
    val userId = auth.currentUser?.uid

    val db = FirebaseFirestore.getInstance()
    val docRef = db.collection("users").document(userId.toString())

    DisposableEffect(Unit) {
        val listener = docRef
            .addSnapshotListener { snapshot, exception ->
                if (exception != null) {
                    // Handle the error
                    return@addSnapshotListener
                }

                if (snapshot != null && snapshot.exists()) {
                    val data = snapshot.data
                    // Retrieve the integer field from the snapshot and update the State
                    val intValueFromFirestore = data?.get("points") as Long?
                    if (intValueFromFirestore != null) {
                        userPoints = intValueFromFirestore.toInt()
                    }
                }
            }
        onDispose {
            listener.remove()
        }
    }
    GenericUserNumber(number = userPoints, fontSize = 44, color = darkorange)
}