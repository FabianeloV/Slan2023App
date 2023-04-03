package com.example.prototiposlan

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.ui.theme.darkblue


@Composable
fun LoginScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        loginLogo(id = R.drawable.usericon, width = 150, height = 150)
            Spacer(modifier = Modifier.padding(15.dp))
        LoginTitle("INGRESAR", font = 35)
            Spacer(modifier = Modifier.padding(20.dp))
        mail(){ Icon(imageVector = Icons.Outlined.Email, contentDescription = null)}
            Spacer(modifier = Modifier.padding(15.dp))
        password("Contraseña"){ Icon(imageVector = Icons.Outlined.Lock, contentDescription = null)}
            Spacer(modifier = Modifier.padding(15.dp))
        loginButton("INGRESAR", darkblue)
            Spacer(modifier = Modifier.padding(15.dp))
        LoginTitle(text = "O regístrate con", font = 15)
            Spacer(modifier = Modifier.padding(15.dp))
        googleRegisterLogo()
            Spacer(modifier = Modifier.padding(15.dp))
        createAccButton(navController)
    }
}

@Composable
fun loginLogo(id: Int, width: Int, height: Int) {
    Image(painter = painterResource(id = id),
        contentDescription = "Logo usuario",
        modifier = Modifier.size(width = width.dp, height = height.dp))
}

@Composable
fun LoginTitle(text: String, font: Int) {
    Text(text = text, color = darkblue, fontSize = font.sp, fontFamily = FontFamily.Serif)
}


@Composable
fun mail(Icon: @Composable (() -> Unit)) {
    var mail by remember { mutableStateOf("") }

    OutlinedTextField(
        leadingIcon = Icon,
        value = mail,
        onValueChange = { mail = it },
        label = { Text("Correo electronico") },
        shape = shapes.small,
    )
}

@Composable
fun password(label:String, Icon: @Composable (() -> Unit)) {
    var pasword by remember { mutableStateOf("") }

    OutlinedTextField(
        leadingIcon = Icon,
        value = pasword,
        onValueChange = { pasword = it },
        label = { Text(label) },
        shape = shapes.small,
        visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
fun loginButton(text: String, color: Color) {
    Row() {
        OutlinedButton(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = color),
            shape = shapes.small) {
            Text(text = text,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif)

            Spacer(modifier = Modifier.padding(5.dp))

            Image(painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                contentDescription = null)

        }
    }
}

@Composable
fun createAccButton(navController: NavController) {
    OutlinedButton(onClick = { navController.navigate("RegisterScreen") },
        shape = shapes.small,
        border = BorderStroke(2.dp, darkblue)) {
        Text(text = "CREAR UNA CUENTA",
            color = darkblue,
            fontSize = 16.sp,
            fontFamily = FontFamily.Serif)
    }
}

@Composable
fun googleRegisterLogo() {
    IconButton(onClick = { /*TODO*/ }) {
        Image(painter = painterResource(id = R.drawable.google),
            contentDescription = "logo google",
            modifier = Modifier.size(width = 60.dp, height = 60.dp))
    }
}
