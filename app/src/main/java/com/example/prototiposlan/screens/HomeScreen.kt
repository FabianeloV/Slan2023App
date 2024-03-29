package com.example.prototiposlan.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.darkgreen
import com.example.prototiposlan.ui.theme.darkorange
import com.example.prototiposlan.ui.theme.graduateFont
import com.example.prototiposlan.viewModels.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scaffoldState, scope, navController) },
        drawerContent = { DrawerMenu(menuItems = homeViewModel.latMenuItem, navController) },

        content = ({
            DaySchedule(
                homeViewModel.getEventsList(),
                homeViewModel.getDateText()
            )
        }),
        bottomBar = {
            BottomNavigation(backgroundColor = Color.White, elevation = 4.dp) {
                homeViewModel.daysSchedule.forEach { day ->
                    BottomNavigationItem(
                        label = { Text(text = day) },
                        icon = {},
                        selected = day == homeViewModel.selectedDay,
                        onClick = {
                            homeViewModel.selectedDay = day
                        },
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }

    )
}

@Composable
fun TopBar(scaffoldState: ScaffoldState, scope: CoroutineScope, navController: NavController) {
    TopAppBar(
        title = {
            Text(
                "Cronograma",
                color = darkgreen,
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
        1.0f to darkgreen
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = linear)
    ) {
        Spacer(modifier = Modifier.padding(top = 25.dp))

        Image(painter = painterResource(id = R.drawable.slandrawer), contentDescription = null)

        Spacer(modifier = Modifier.padding(top = 25.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
                .background(color = darkorange)
                .padding(top = 20.dp)
        )
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(color = darkorange)
                .padding(top = 20.dp)
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))

        menuItems.subList(0, 3).forEach { item ->
            DrawerItem(item = item, navController)
        }

        Spacer(modifier = Modifier.padding(top = 5.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(color = darkorange)
                .padding(top = 20.dp)
        )

        Spacer(modifier = Modifier.padding(top = 5.dp))

        menuItems.subList(3, 6).forEach { item ->
            DrawerItem(item = item, navController)
        }

        Spacer(modifier = Modifier.padding(top = 5.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(color = darkorange)
                .padding(top = 20.dp)
        )

        Spacer(modifier = Modifier.padding(top = 5.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
                .background(color = darkorange)
                .padding(top = 20.dp)
        )
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
                    modifier = Modifier.size(28.dp),
                    tint = darkorange
                )
                Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                Text(
                    text = item.title,
                    color = darkgreen,
                    fontSize = 22.sp,
                    fontFamily = graduateFont
                )
            }
        }
    }
}

@Composable
fun DaySchedule(eventsList: List<Schedule>, dateText: String) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {

        item { DateText(text = dateText) }

        item { eventsList.forEach { event -> EventColumn(event = event) } }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EventColumn(event: Schedule) {
    Card(
        elevation = 6.dp,
        modifier = Modifier.padding(top = 5.dp),
        onClick = { event.showDialog.value = !event.showDialog.value }) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Text(text = event.event, modifier = Modifier.padding(bottom = 4.dp))

            Text(text = event.code, modifier = Modifier.padding(bottom = 4.dp), color = darkorange)

            Row(Modifier.fillMaxWidth()) {
                Icon(Icons.Outlined.LocationOn, contentDescription = event.event)
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Text(text = event.ubication, color = Color.Gray)
            }

            Row(Modifier.fillMaxWidth()) {
                Icon(Icons.Outlined.Face, contentDescription = event.event)
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Text(text = event.speaker, color = Color.Gray)
            }

            Row(Modifier.fillMaxWidth()) {
                Icon(Icons.Outlined.DateRange, contentDescription = event.event)
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Text(text = event.hour, color = Color.Gray)

                if (event.description.isNotEmpty()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Icon(Icons.Filled.ArrowDropDown, contentDescription = "Show description")
                    }
                }
            }
            AnimatedVisibility(visible = event.showDialog.value) {
                Text(
                    text = event.description,
                    color = Color.Black,
                    modifier = Modifier.padding(6.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun DateText(text: String) {
    Text(
        text = text,
        color = darkorange,
        fontFamily = graduateFont,
        fontSize = 22.sp,
        modifier = Modifier.padding(15.dp)
    )
}