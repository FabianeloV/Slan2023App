package com.example.prototiposlan.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.Textos
import com.example.prototiposlan.ui.theme.darkblue
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.monogram
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val latMenuItem = listOf(
        LatMenuScreens.Usuario,
        LatMenuScreens.Muro,
        LatMenuScreens.Presentaciones,
        LatMenuScreens.Mapa
    )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(title = "HOME PAGE", scaffoldState, scope) },
        drawerContent = { DrawerMenu(menuItems = latMenuItem, navController) },
        content = ({ HomeInfo()})
        )
}

@Composable
fun TopBar(title: String, scaffoldState: ScaffoldState, scope: CoroutineScope) {
    TopAppBar(
        title = {
            Text(
                title,
                color = darkblue,
                fontFamily = monogram,
                fontSize = 25.sp,
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
        elevation = 1.dp
    )
}

@Composable
fun DrawerMenu(menuItems: List<LatMenuScreens>, navController: NavController) {
    Column(modifier = Modifier.padding(top = 40.dp, bottom = 40.dp)) {
        Image(
            painter = painterResource(id = R.drawable.fonotipo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentScale = ContentScale.FillWidth
        )
        menuItems.forEach{ item ->
            DrawerItem(item = item, navController)
        }
    }
}

@Composable
fun DrawerItem(item: LatMenuScreens, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, start = 10.dp, end = 10.dp)
            .height(56.dp)
    ) {
        OutlinedButton(onClick = { navController.navigate(route = item.route) },
            modifier = Modifier.fillMaxSize(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            border = BorderStroke(5.dp, darkblue)
        ) {
            Spacer(modifier = Modifier.padding(horizontal = 12.dp))
            Image(painter = painterResource(id = item.icon),
                contentDescription = item.title,
                modifier = Modifier.size(28.dp))
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            Text(text = item.title, fontFamily = FontFamily.Serif, color = darkblue, fontSize = 22.sp)
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


