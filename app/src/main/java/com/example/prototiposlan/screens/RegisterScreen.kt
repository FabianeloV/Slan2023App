package com.example.prototiposlan.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.R
import com.example.prototiposlan.authenticationFiles.LoginViewModel
import com.example.prototiposlan.ui.theme.darkblue
import com.example.prototiposlan.ui.theme.darkred
import com.example.prototiposlan.ui.theme.monogram


@Composable
fun RegisterScreen(navController: NavController, viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {

    val mail = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val repeatedPassword = rememberSaveable { mutableStateOf("") }

    val gradient =
        Brush.verticalGradient(
            0.77f to Color.White,
            1.0f to darkblue,
            startY = 0.0f,
            endY = 2500.0f
        )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(top = 85.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RegisterTitle()

        Spacer(modifier = Modifier.padding(25.dp))

        OutlinedTextField(
            leadingIcon = { Icon(imageVector = Icons.Outlined.Email, contentDescription = null) },
            value = mail.value,
            onValueChange = { mail.value = it },
            label = { Text("Correo electrónico") },
            shape = MaterialTheme.shapes.small,
        )

        Spacer(modifier = Modifier.padding(25.dp))

        OutlinedTextField(
            leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = null) },
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Contraseña") },
            shape = MaterialTheme.shapes.small,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(25.dp))

        OutlinedTextField(
            leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = null) },
            value = repeatedPassword.value,
            onValueChange = { repeatedPassword.value = it },
            label = { Text("Repetir contraseña") },
            shape = MaterialTheme.shapes.small,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(25.dp))

        GoogleRegisterLogo()

        Spacer(modifier = Modifier.padding(25.dp))

        CreateButton{viewModel.createUser(
            email = mail.value,
            password = password.value,
            repeatedPassword = repeatedPassword.value,
            {navController.navigate(route = "HomeScreen")},
            {Toast.makeText(null, "Ingrese una contraseña válida", Toast.LENGTH_SHORT).show()},
            {Toast.makeText(null, "Ingrese un correo válido", Toast.LENGTH_SHORT).show()},
            {Toast.makeText(null, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()}
        )}
    }
}

@Composable
fun RegisterTitle() {
    Text(
        text = "Crear una cuenta",
        color = darkred,
        fontSize = 40.sp,
        fontFamily = monogram
    )
}

@Composable
fun CreateButton(
    function: () -> Unit
) {
    OutlinedButton(
        onClick = {
            function()
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = darkred),
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = "CREAR CUENTA",
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = FontFamily.Serif
        )

        Spacer(modifier = Modifier.padding(5.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
            contentDescription = null
        )
    }
}


