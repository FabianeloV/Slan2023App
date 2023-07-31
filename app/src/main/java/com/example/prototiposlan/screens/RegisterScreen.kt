package com.example.prototiposlan.screens

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.R
import com.example.prototiposlan.viewModels.LoginViewModel
import com.example.prototiposlan.ui.theme.darkred
import com.example.prototiposlan.ui.theme.graduateFont
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val mail = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val repeatedPassword = rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current

    //Google client
    val token = "638724186254-5ip7kj91ljfqlua9u663fk7djtlh0a9i.apps.googleusercontent.com"
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try {
                val account = task.getResult(ApiException::class.java)
                val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                viewModel.singInGoogle(credential,
                    { navController.navigate(route = "HomeScreen") },
                    { Toast.makeText(context, "Error de ingreso", Toast.LENGTH_SHORT).show() })
            } catch (ex: Exception) {
                Log.d("Logueo google", "Error de logueo con google: ${ex.message}")
            }
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ShaderBrush(ImageShader(ImageBitmap.imageResource(id = R.drawable.singinbackground))))
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginLogo(id = R.drawable.usericon, width = 150, height = 150)

        Spacer(modifier = Modifier.padding(15.dp))

        RegisterTitle()

        Spacer(modifier = Modifier.padding(20.dp))

        OutlinedTextField(
            leadingIcon = { Icon(imageVector = Icons.Outlined.Email, contentDescription = null) },
            value = mail.value,
            onValueChange = { mail.value = it },
            label = { Text("Correo electrónico") },
            shape = CircleShape,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        Spacer(modifier = Modifier.padding(20.dp))

        OutlinedTextField(
            leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = null) },
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Contraseña") },
            shape = CircleShape,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(20.dp))

        OutlinedTextField(
            leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = null) },
            value = repeatedPassword.value,
            onValueChange = { repeatedPassword.value = it },
            label = { Text("Repetir contraseña") },
            shape = CircleShape,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(15.dp))

        GoogleRegisterLogo {
            Toast.makeText(context, "Cargando...", Toast.LENGTH_SHORT).show()

            val opciones = GoogleSignInOptions.Builder(
                GoogleSignInOptions.DEFAULT_SIGN_IN
            )
                .requestIdToken(token)
                .requestEmail()
                .build()
            val googleClient = GoogleSignIn.getClient(context, opciones)
            launcher.launch(googleClient.signInIntent)
        }

        Spacer(modifier = Modifier.padding(15.dp))

        CreateButton {
            viewModel.createUser(
                email = mail.value,
                password = password.value,
                repeatedPassword = repeatedPassword.value,
                { navController.navigate(route = "HomeScreen")},
                { Toast.makeText(context, "Ingrese una contraseña de 6 o más caracteres", Toast.LENGTH_SHORT).show() },
                { Toast.makeText(context, "Ingrese un correo válido", Toast.LENGTH_SHORT).show() },
                { Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show() },
                { Toast.makeText(context, "Error de registro", Toast.LENGTH_SHORT).show() }
            )
        }
    }
}

@Composable
fun RegisterTitle() {
    Text(
        text = "Crear una cuenta",
        color = darkred,
        fontSize = 32.sp,
        fontFamily = graduateFont
    )
}

@Composable
fun CreateButton(
    function: () -> Unit
) {
    val context = LocalContext.current

    OutlinedButton(
        onClick = {
            Toast.makeText(context, "Cargando...", Toast.LENGTH_SHORT).show()
            function()
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = darkred),
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = "CREAR CUENTA",
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = graduateFont
        )

        Spacer(modifier = Modifier.padding(5.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
            contentDescription = null
        )
    }
}


