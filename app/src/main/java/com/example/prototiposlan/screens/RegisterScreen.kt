package com.example.prototiposlan.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
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
import com.example.prototiposlan.ui.theme.darkorange
import com.example.prototiposlan.ui.theme.graduateFont

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val mail = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val repeatedPassword = rememberSaveable { mutableStateOf("") }
    val nickName = rememberSaveable { mutableStateOf("") }
    val age = rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ShaderBrush(ImageShader(ImageBitmap.imageResource(id = R.drawable.singinbackground))))
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginLogo(id = R.drawable.usericon, width = 150, height = 150)

        Spacer(modifier = Modifier.padding(15.dp))

        RegisterTitle()

        Spacer(modifier = Modifier.padding(15.dp))

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

        OutlinedTextField(
            leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = null) },
            value = repeatedPassword.value,
            onValueChange = { repeatedPassword.value = it },
            label = { Text("Repetir contraseña") },
            shape = CircleShape,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(15.dp))

        OutlinedTextField(
            leadingIcon = { Icon(imageVector = Icons.Outlined.Face, contentDescription = null) },
            value = nickName.value,
            onValueChange = { nickName.value = it },
            label = { Text("Nombre de usuario") },
            shape = CircleShape
        )

        Spacer(modifier = Modifier.padding(15.dp))

        OutlinedTextField(
            leadingIcon = { Icon(imageVector = Icons.Outlined.DateRange, contentDescription = null)},
            value = age.value,
            onValueChange = {age.value = it},
            label = { Text("Edad")},
            shape = CircleShape
        )

        Spacer(modifier = Modifier.padding(15.dp))

        CreateButton {
            viewModel.createUser(
                email = mail.value,
                password = password.value,
                repeatedPassword = repeatedPassword.value,
                nickName = nickName.value,
                avatar = "",
                age = age.value,
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
        color = darkorange,
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
        colors = ButtonDefaults.buttonColors(backgroundColor = darkorange),
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