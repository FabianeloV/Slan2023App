package com.example.prototiposlan

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prototiposlan.ui.theme.darkblue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Preview
@Composable
fun HomeScreen() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val LatMenuItem = listOf(
        LatMenuScreens.Usuario,
        LatMenuScreens.Muro,
        LatMenuScreens.Presentaciones,
        LatMenuScreens.Mapa
    )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { topBar(title = "HOME PAGE", scaffoldState, scope) },
        drawerContent = { DrawerMenu(menuItems = LatMenuItem) }
    ) {
        HomeInfo()

    }

}

@Composable
fun topBar(title: String, scaffoldState: ScaffoldState, scope: CoroutineScope) {
    TopAppBar(
        title = {
            Text(
                title,
                color = darkblue,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 55.dp)
            )
        },
        navigationIcon = {
            IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
                Icon(Icons.Filled.Menu, contentDescription = null)
            }
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Image(
                    painter = painterResource(id = R.drawable.usericon),
                    contentDescription = null,
                    modifier = Modifier.padding(all = 1.dp)
                )
            }
        }
    )
}

@Composable
fun DrawerMenu(menuItems: List<LatMenuScreens>) {
    Column(modifier = Modifier.padding(top = 20.dp)) {
        Image(
            painter = painterResource(id = R.drawable.fonotipo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp),
            contentScale = ContentScale.FillWidth
        )

        menuItems.forEach { item ->
            DrawerItem(item = item)
        }
    }
}

@Composable
fun DrawerItem(item: LatMenuScreens) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(56.dp)
    ) {
        Spacer(modifier = Modifier.padding(horizontal = 15.dp))
        Image(painter = painterResource(id = item.icon), contentDescription = item.title, modifier = Modifier.size(28.dp))
        Spacer(modifier = Modifier.padding(horizontal = 10.dp))
        Text(text = item.title, fontFamily = FontFamily.Serif, color = darkblue, fontSize = 24.sp)
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


