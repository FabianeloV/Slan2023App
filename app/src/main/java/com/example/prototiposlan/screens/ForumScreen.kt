package com.example.prototiposlan.screens

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.prototiposlan.ui.theme.darkblue

@Composable
fun ForumScreen(navController: NavController) {
    Scaffold(
        topBar = { GeneralTopBar(title = "MURO", navController = navController) },
        content = ({}),
        bottomBar = ({ TextBox() })
    )
}

@Composable
fun TextBox() {
    val context = LocalContext.current
    val text = rememberSaveable { mutableStateOf("") }
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.White,
        elevation = 1.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp), horizontalArrangement = Arrangement.SpaceAround
        ) {

            OutlinedTextField(
                value = text.value,
                onValueChange = { text.value = it },
                shape = CircleShape,
                modifier = Modifier.height(550.dp).width(300.dp).border(color = darkblue, width = 2.dp, shape = CircleShape)
            )

            Button(
                onClick = { Toast.makeText(context, "Subiendo...", Toast.LENGTH_SHORT).show() },
                colors = ButtonDefaults.buttonColors(backgroundColor = darkblue),
                shape = RoundedCornerShape(3.dp)
            ) {
                Icon(
                    Icons.Outlined.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}