package com.example.prototiposlan.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
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
import com.example.prototiposlan.ui.theme.darkblue
import com.example.prototiposlan.ui.theme.darkred
import com.google.firebase.auth.FirebaseAuth


@Composable
fun RegisterScreen(navController: NavController) {

    var mail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatedPassword by remember { mutableStateOf("") }
    val passwordAlertValue = remember { mutableStateOf(false) }
    val mailAlertValue = remember { mutableStateOf(false) }
    val test = remember { mutableStateOf(false) }



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
            value = mail,
            onValueChange = { mail = it },
            label = { Text("Correo electronico") },
            shape = MaterialTheme.shapes.small,
        )

        Spacer(modifier = Modifier.padding(25.dp))

        OutlinedTextField(
            leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = null) },
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            shape = MaterialTheme.shapes.small,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(25.dp))

        OutlinedTextField(
            leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = null) },
            value = repeatedPassword,
            onValueChange = { repeatedPassword = it },
            label = { Text("Repetir contraseña") },
            shape = MaterialTheme.shapes.small,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(25.dp))

        GoogleRegisterLogo()

        Spacer(modifier = Modifier.padding(25.dp))

        CreateButton(
            mail,
            password,
            repeatedPassword,
            navController,
            { passwordAlertValue.value = true },
            { mailAlertValue.value = true },
            { test.value = true })

        if (passwordAlertValue.value) {
            AlertDialogM(text = "Las contraseñas no coinciden") {
                passwordAlertValue.value = false
            }
        }

        if (mailAlertValue.value) {
            AlertDialogM(text = "Ingrese un correo válido") {
                mailAlertValue.value = false
            }
        }

        if (test.value) {
            AlertDialogM(text = "Succes") {
                test.value = false
            }
        }
    }
}

@Composable
fun RegisterTitle() {
    Text(
        text = "Crear una cuenta",
        color = darkred,
        fontSize = 40.sp,
        fontFamily = FontFamily.Serif
    )
}


fun signIn(
    email: String,
    password: String,
    repeatedPassword: String,
    onSignInSuccess: () -> Unit,
    PasswordAlert: () -> Unit,
    MailAlert: () -> Unit,
    test: () -> Unit
) {
    val auth = FirebaseAuth.getInstance()

    if (email.isNotEmpty()) {
        if (password == repeatedPassword) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        onSignInSuccess()
                        test()
                    }
                }
        } else {
            PasswordAlert()
        }
    } else {
        MailAlert()
    }
}

@Composable
fun AlertDialogM(text: String, CloseDialog: () -> Unit) {
    AlertDialog(
        onDismissRequest = {
            CloseDialog()
        },
        title = {
            Text(text = "ERROR")
        },
        text = {
            Text(text)
        },
        buttons = {
            Row(
                modifier = Modifier.padding(all = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { CloseDialog() }
                ) {
                    Text("Cerrar")
                }
            }
        }
    )
}

@Composable
fun CreateButton(
    mail: String,
    password: String,
    repeatedPassword: String,
    navController: NavController,
    PasswordAlert: () -> Unit,
    MailAlert: () -> Unit,
    function: () -> Unit
) {
    OutlinedButton(
        onClick = {
            signIn(
                email = mail,
                password = password,
                repeatedPassword = repeatedPassword,
                onSignInSuccess = { navController.navigate(route = "HomeScreen") },
                PasswordAlert,
                MailAlert,
                function
            )
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


