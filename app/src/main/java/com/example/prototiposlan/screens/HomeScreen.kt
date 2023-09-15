package com.example.prototiposlan.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.ui.theme.darkblue
import com.example.prototiposlan.ui.theme.darkred
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
        bottomBar = {
            BottomNavigation {
                homeViewModel.daysSchedule.forEach { day ->
                    BottomNavigationItem(
                        label = { Text(text = day.text) },
                        icon = {},
                        selected = day == homeViewModel.selectedDay,
                        onClick = {
                            homeViewModel.selectedDay = day
                            day.click
                        },
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        },
        content = ({ DaySchedule(homeViewModel) })
    )
}

@Composable
fun TopBar(scaffoldState: ScaffoldState, scope: CoroutineScope, navController: NavController) {
    TopAppBar(
        title = {
            Text(
                "Cronograma",
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
fun DaySchedule(homeViewModel: HomeViewModel) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {

        item { DateText(text = "21 de Octubre") }

        item { homeViewModel.firstDayEvents.forEach { event -> EventColumn(event = event) } }

        item { DateText(text = "22 de Octubre") }

        item { homeViewModel.secondDayEvents.forEach { event -> EventColumn(event = event) } }

        item { DateText(text = "23 de Octubre") }

        item { homeViewModel.thirdDayEvents.forEach { event -> EventColumn(event = event) } }

        item { DateText(text = "24 de Octubre") }

        item { homeViewModel.fourthDayEvents.forEach { event -> EventColumn(event = event) } }

        item { DateText(text = "25 de Octubre") }

        item { homeViewModel.fifthDayEvents.forEach { event -> EventColumn(event = event) } }

        item { DateText(text = "26 de Octubre") }
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
            Text(text = event.event, modifier = Modifier.padding(bottom = 8.dp))

            Row(Modifier.fillMaxWidth()) {
                Icon(Icons.Outlined.LocationOn, contentDescription = event.event)
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Text(text = event.ubication, color = Color.Gray)
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
                    modifier = Modifier.padding(6.dp)
                )
            }
        }
    }
}

@Composable
fun DateText(text: String) {
    Text(
        text = text,
        color = darkred,
        fontFamily = graduateFont,
        fontSize = 22.sp,
        modifier = Modifier.padding(15.dp)
    )
}