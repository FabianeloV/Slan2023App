package com.example.prototiposlan

import android.content.res.ColorStateList
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prototiposlan.ui.theme.darkblue

@Preview
@Composable
fun loginScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        logo(id = R.drawable.usericon, width = 150, height = 150)
        Spacer(modifier = Modifier.padding(15.dp))
        text("INGRESAR", font = 35)
        Spacer(modifier = Modifier.padding(20.dp))
        mail()
        Spacer(modifier = Modifier.padding(15.dp))
        pasword()
        Spacer(modifier = Modifier.padding(15.dp))
        Button()
        Spacer(modifier = Modifier.padding(15.dp))
        text(text = "O regístrate con", font = 15)
        Spacer(modifier = Modifier.padding(15.dp))
        logo(id = R.drawable.google, width = 60, height = 60)
        Spacer(modifier = Modifier.padding(15.dp))
        ButtonTwo()
    }
}

@Composable
fun logo(id: Int, width: Int, height: Int) {
    Image(painter = painterResource(id = id),
        contentDescription = "Logo usuario",
        modifier = Modifier.size(width = width.dp, height = height.dp))
}

@Composable
fun text(text: String, font: Int) {
    Text(text = text, color = darkblue, fontSize = font.sp, fontFamily = FontFamily.Serif)
}


@Composable
fun mail() {
    var mail by remember { mutableStateOf("") }

    OutlinedTextField(
        value = mail,
        onValueChange = { mail = it },
        label = { Text("Correo electronico") },
        shape = shapes.small
    )
}

@Composable
fun pasword() {
    var pasword by remember { mutableStateOf("") }

    OutlinedTextField(
        value = pasword,
        onValueChange = { pasword = it },
        label = { Text("Contraseña") },
        shape = shapes.small,
        visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
fun Button() {
    Row() {
        OutlinedButton(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = darkblue),
            shape = shapes.small) {
            Text(text = "INGRESAR",
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
fun ButtonTwo() {
    OutlinedButton(onClick = { /*TODO*/ },
        shape = shapes.small,
        border = BorderStroke(2.dp, darkblue)) {
        Text(text = "CREAR UNA CUENTA",
            color = darkblue,
            fontSize = 16.sp,
            fontFamily = FontFamily.Serif)
    }
}

