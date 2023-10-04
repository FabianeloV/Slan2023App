package com.example.prototiposlan.screens

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import com.example.prototiposlan.viewModels.LoginViewModel
import com.example.prototiposlan.ui.theme.darkgreen
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.graduateFont
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val mail = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }

    //Google client
    val context = LocalContext.current
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
            .background(ShaderBrush(ImageShader(ImageBitmap.imageResource(id = R.drawable.loginbackground))))
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
            shape = CircleShape,
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
            shape = CircleShape,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(15.dp))

        LoginButton {
            viewModel.logIn(
                email = mail.value,
                password = password.value,
                { navController.navigate(route = "HomeScreen") {navController.popBackStack()}},
                { Toast.makeText(context, "Ingrese una contraseña válida", Toast.LENGTH_SHORT).show() },
                { Toast.makeText(context, "Ingrese un correo válido", Toast.LENGTH_SHORT).show() },
                { Toast.makeText(context, "Error de ingreso", Toast.LENGTH_SHORT).show() }
            )
        }

        Spacer(modifier = Modifier.padding(15.dp))

        LoginTitle(text = "O regístrate con", font = 25)

        Spacer(modifier = Modifier.padding(15.dp))

        GoogleRegisterLogo {
            Toast.makeText(context, "Cargando...", Toast.LENGTH_SHORT).show()
            navController.popBackStack()
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
    Text(text = text, color = darkgreen, fontSize = font.sp, fontFamily = graduateFont)
}

@Composable
fun LoginButton(click: () -> Unit) {

    val context = LocalContext.current

    OutlinedButton(
        onClick = {
            Toast.makeText(context, "Cargando...", Toast.LENGTH_LONG).show()
            click()
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = darkgreen),
        shape = CircleShape
    ) {
        Text(
            text = "INGRESAR",
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = graduateFont)

        Spacer(modifier = Modifier.padding(5.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
            contentDescription = null
        )
    }
}


@Composable
fun CreateAccButton(navController: NavController) {
    OutlinedButton(
        onClick = { navController.navigate("RegisterScreen") },
        shape = shapes.small,
        border = BorderStroke(2.dp, darkgreen)
    ) {
        Text(
            text = "CREAR UNA CUENTA",
            color = darkgreen,
            fontSize = 16.sp,
            fontFamily = graduateFont)
    }
}

@Composable
fun GoogleRegisterLogo(click: () -> Unit) {
    IconButton(onClick = { click() }) {
        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = "logo google",
            modifier = Modifier.size(width = 60.dp, height = 60.dp)
        )
    }
}
