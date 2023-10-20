package com.example.prototiposlan.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Info
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
import coil.compose.AsyncImage
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

    val dialogState = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            GeneralTopBar(
                title = "USUARIO",
                navController = navController
            ) { dialogState.value = true }
        },
        content = ({ UserContent(steps) })
    )
    if (dialogState.value) {
        DialogInfo(close = { dialogState.value = false }, title = "Usuario", text = "")
    }
}

@Composable
fun GeneralTopBar(title: String, navController: NavController, action: () -> Unit) {
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
        actions = {
            IconButton(onClick = { action() }) {
                Icon(Icons.Outlined.Info, contentDescription = null)
            }
        },
        backgroundColor = Color.Transparent,
        elevation = 1.dp,
    )
}

@Composable
fun DialogInfo(close: () -> Unit, title: String, text: String) {
    AlertDialog(
        onDismissRequest = { close() },
        title = { Text(text = title) },
        text = { Text(text = text) },
        confirmButton = { },
        shape = Shapes.small
    )
}

@Composable
fun UserContent(Steps: Int) {
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
        AsyncImage(
            model = getAvatarUrl(),
            placeholder = painterResource(id = R.drawable.usericon),
            error = painterResource(id = R.drawable.usericon),
            contentDescription = "user avatar",
            modifier = Modifier
                .clip(CircleShape)
                .size(width = 150.dp, height = 150.dp)
                .border(1.dp, color = darkgreen, shape = CircleShape)
        )

        Spacer(modifier = Modifier.padding(25.dp))

        GenericUserText(text = getNickname(), fontSize = 28, color = Color.Black)

        Spacer(modifier = Modifier.padding(16.dp))

        GenericUserNumber(number = steps, fontSize = 44, color = darkorange)

        RowWithIcon()

        Spacer(modifier = Modifier.padding(20.dp))

        GenericUserNumber(number = calories.toInt(), fontSize = 44, color = darkorange)

        GenericUserText(text = "cal quemadas", fontSize = 32, color = darkgreen)

        Spacer(modifier = Modifier.padding(20.dp))

        GenericUserNumber(number = points(), fontSize = 44, color = darkorange)

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
        GenericUserText(text = "Pasos totales", fontSize = 32, color = darkgreen)
    }
}

@Composable
fun points(): Int {
    var userPoints by remember { mutableStateOf(0) }

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
    return userPoints
}

@Composable
fun getAvatarUrl(): String {
    val avatarUrl = remember { mutableStateOf("") }

    val auth: FirebaseAuth = Firebase.auth
    val userId = auth.currentUser?.uid

    val db = FirebaseFirestore.getInstance()
    val docRef = db.collection("users").document(userId.toString())

    docRef.get().addOnSuccessListener { documentSnapshot ->
        if (documentSnapshot.exists()) {

            val fieldValue = documentSnapshot.getString("avatar")
            if (fieldValue != null) {
                avatarUrl.value = fieldValue.toString()
            } else {
                avatarUrl.value = ""
            }
        }
    }
        .addOnFailureListener { exception ->
            println("Error getting document: $exception")
        }

    return avatarUrl.value
}

@Composable
fun getNickname(): String {
    val userNickname = remember { mutableStateOf("") }

    val auth: FirebaseAuth = Firebase.auth
    val userId = auth.currentUser?.uid
    val db = FirebaseFirestore.getInstance()
    val docRef = db.collection("users").document(userId.toString())

    docRef.get().addOnSuccessListener { documentSnapshot ->
        if (documentSnapshot.exists()) {

            val fieldValue = documentSnapshot.getString("nickname")?.split(" ")?.get(0)
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

    return userNickname.value
}

