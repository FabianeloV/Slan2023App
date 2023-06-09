package com.example.prototiposlan.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.Textos
import com.example.prototiposlan.ui.theme.darkblue
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.darkred
import com.example.prototiposlan.ui.theme.graduateFont
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val latMenuItem = listOf(
        LatMenuScreens.Usuario,
        LatMenuScreens.Ranking,
        LatMenuScreens.Reto,
        LatMenuScreens.Muro,
        LatMenuScreens.Ejercicios,
        LatMenuScreens.Rutinas,
        LatMenuScreens.Tabla,
        LatMenuScreens.Mapa,
        LatMenuScreens.Plantas
    )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(title = "HOME PAGE", scaffoldState, scope) },
        drawerContent = { DrawerMenu(menuItems = latMenuItem, navController) },
        content = ({ HomeInfo() })
    )
}

@Composable
fun TopBar(title: String, scaffoldState: ScaffoldState, scope: CoroutineScope) {
    val linear = Brush.linearGradient(
        0.77f to Color.White,
        1.0f to darkblue
    )
    TopAppBar(
        title = {
            Text(
                title,
                color = darkblue,
                fontSize = 25.sp,
                fontFamily = graduateFont,
                modifier = Modifier
                    .fillMaxWidth()
            )
        },
        navigationIcon = {
            IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
                Icon(Icons.Filled.Menu, contentDescription = null)
            }
        },
        backgroundColor = Color.Transparent,
        elevation = 1.dp,
        modifier = Modifier.background(linear)
    )
}

@Composable
fun DrawerMenu(menuItems: List<LatMenuScreens>, navController: NavController) {
    val linear = Brush.verticalGradient(
        0.82f to Color.White,
        1.0f to darkblue
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = linear)
    ) {
        Spacer(modifier = Modifier.padding(top = 25.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(16.dp)
            .background(color = darkred)
            .padding(top = 20.dp))
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp)
            .background(color = darkred)
            .padding(top = 20.dp))
        Spacer(modifier = Modifier.padding(top = 10.dp))
        menuItems.forEach { item ->
            DrawerItem(item = item, navController)
        }
    }
}

@Composable
fun DrawerItem(item: LatMenuScreens, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 8.dp, end = 8.dp)
            .height(56.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        OutlinedButton(
            onClick = { navController.navigate(route = item.route) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            border = BorderStroke(1.dp, Color.Transparent)
        ) {
            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Start) {
                Icon(
                    painter = painterResource(id = item.icon),
                    contentDescription = item.title,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                Text(
                    text = item.title,
                    color = darkblue,
                    fontSize = 22.sp,
                    fontFamily = graduateFont
                )
            }
        }
    }
}

@Composable
fun HomeInfo() {

    val textos = Textos()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cuencaciudad),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        item {
            Spacer(modifier = Modifier.padding(top = 20.dp))
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = textos.textoCuenca, fontFamily = FontFamily.Serif
                )
                Image(
                    painter = painterResource(id = R.drawable.escudocuenca),
                    contentDescription = null,
                    modifier = Modifier.size(width = 200.dp, height = 200.dp)
                )
            }
        }

        item {
            Spacer(modifier = Modifier.padding(top = 20.dp))
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ucuenca),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(width = 335.dp, height = 235.dp)
                        .padding(end = 10.dp)
                )
            }
        }

        item {
            Spacer(modifier = Modifier.padding(top = 20.dp))
        }

        item {
            Text(
                text = textos.textoUCuenca,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(all = 10.dp)
            )
        }
    }
}


