package com.example.prototiposlan.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.ui.theme.darkblue
import com.example.prototiposlan.ui.theme.darkred
import com.example.prototiposlan.ui.theme.graduateFont
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
@Composable
fun HomeScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val latMenuItem = listOf(
        LatMenuScreens.Ranking,
        LatMenuScreens.Reto,
        LatMenuScreens.Muro,
        LatMenuScreens.Mapa,
        LatMenuScreens.Flora,
        LatMenuScreens.Album
    )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scaffoldState, scope, navController) },
        drawerContent = { DrawerMenu(menuItems = latMenuItem, navController) },
        content = ({ HomeInfo() })
    )
}

@Composable
fun TopBar(scaffoldState: ScaffoldState, scope: CoroutineScope, navController: NavController) {
    TopAppBar(
        title = {
            Text(
                "Home page",
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
        actions = {
            IconButton(onClick = { navController.navigate(route = "UserScreen") }) {
                Icon(Icons.Filled.Face, contentDescription = null)
            }
        },
        backgroundColor = Color.Transparent,
        elevation = 1.dp,
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
                .background(color = darkred)
                .padding(top = 20.dp)
        )
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(color = darkred)
                .padding(top = 20.dp)
        )
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
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
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

}

@Preview
@Composable
fun DaySchedule(){
    LazyColumn(content = {})
}


