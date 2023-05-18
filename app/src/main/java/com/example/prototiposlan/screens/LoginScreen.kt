package com.example.prototiposlan.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.shapes
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.authenticationFiles.LoginViewModel
import com.example.prototiposlan.ui.theme.darkblue
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.darkred
import com.example.prototiposlan.ui.theme.monogram


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val gradient = Brush.verticalGradient(
        0.77f to Color.White,
        1.0f to darkred,
        startY = 0.0f,
        endY = 2500.0f
    )

    val mail = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginLogo(id = R.drawable.usericon, width = 150, height = 150)

        Spacer(modifier = Modifier.padding(15.dp))

        LoginTitle("INGRESAR", font = 35)

        Spacer(modifier = Modifier.padding(20.dp))

        OutlinedTextField(
            leadingIcon = { Icon(imageVector = Icons.Outlined.Email, contentDescription = null) },
            value = mail.value,
            onValueChange = { mail.value = it },
            label = { Text("Correo electrónico") },
            shape = shapes.small,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        Spacer(modifier = Modifier.padding(15.dp))

        OutlinedTextField(
            leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = null) },
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Contraseña") },
            shape = shapes.small,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(15.dp))

        LoginButton {
            viewModel.logIn(
                email = mail.value,
                password = password.value,
                { navController.navigate(route = "HomeScreen") },
                { Toast.makeText(null, "Ingrese una contraseña válida", Toast.LENGTH_SHORT).show()},
                { Toast.makeText(null, "Ingrese un correo válido", Toast.LENGTH_SHORT).show()}
            )
        }

        Spacer(modifier = Modifier.padding(15.dp))

        LoginTitle(text = "O regístrate con", font = 15)

        Spacer(modifier = Modifier.padding(15.dp))

        GoogleRegisterLogo()

        Spacer(modifier = Modifier.padding(15.dp))

        CreateAccButton(navController)
    }
}

@Composable
fun LoginLogo(id: Int, width: Int, height: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = "Logo usuario",
        modifier = Modifier.size(width = width.dp, height = height.dp)
    )
}

@Composable
fun LoginTitle(text: String, font: Int) {
    Text(text = text, color = darkblue, fontSize = font.sp, fontFamily = monogram)
}

@Composable
fun LoginButton(click: () -> Unit) {
    Row {
        OutlinedButton(
            onClick = { click() },
            colors = ButtonDefaults.buttonColors(backgroundColor = darkblue),
            shape = CircleShape
        ) {
            Text(
                text = "INGRESAR",
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
}

@Composable
fun CreateAccButton(navController: NavController) {
    OutlinedButton(
        onClick = { navController.navigate("RegisterScreen") },
        shape = shapes.small,
        border = BorderStroke(2.dp, darkblue)
    ) {
        Text(
            text = "CREAR UNA CUENTA",
            color = darkblue,
            fontSize = 16.sp,
            fontFamily = FontFamily.Serif
        )
    }
}

@Composable
fun GoogleRegisterLogo() {
    IconButton(onClick = { /*TODO*/ }) {
        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = "logo google",
            modifier = Modifier.size(width = 60.dp, height = 60.dp)
        )
    }
}
