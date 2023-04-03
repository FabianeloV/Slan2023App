package com.example.prototiposlan

import android.app.ProgressDialog.show
import android.content.ClipData.Item
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prototiposlan.ui.theme.darkblue
import com.example.prototiposlan.ui.theme.darkred
import kotlinx.coroutines.CoroutineScope
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview
@Composable
fun HomeScreen() {
    Column() {
        topBar("Home page")
        HomeInfo()
    }

}

@Composable
fun topBar(title: String) {
    TopAppBar(
        title = { Text(title, color = darkblue, fontFamily = FontFamily.Serif) },
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Menu, contentDescription = null)
            }
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Outlined.AccountBox, contentDescription = "Localized description")
            }
        }
    )
}

@Composable
fun HomeInfo() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id = R.drawable.cuenca),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "La ciudad lleva el nombre de\n" +
                            "Santa Ana de los 4 Ríos de\n" +
                            "Cuenca en honor a la ciudad\n" +
                            "Cuenca en España, lugar de\n" +
                            "nacimiento del virrey español\n" +
                            "del Perú Andrés Mendoza, quien\n" +
                            "fue el que mandó a fundar la\n" +
                            "ciudad al español Gil Ramírez\n" +
                            "Dávalos y al hecho de que este\n" +
                            "lugar, en sus accidentes\n" +
                            "geográficos, se parece mucho a\n" +
                            "la ciudad española."
                )

                Image(painter = painterResource(id = R.drawable.escudocuenca), contentDescription = null)
            }
        }
    }
}


