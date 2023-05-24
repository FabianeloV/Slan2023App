package com.example.prototiposlan.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.darkblue
import com.example.prototiposlan.viewModels.LoginViewModel
import com.example.prototiposlan.viewModels.MapviewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(navController: NavController) {
    Scaffold(
        topBar = { GeneralTopBar(title = "MAPAS", navController = navController) },
        content = ({ GoogleMapScreen() }),
        bottomBar = { MapBottomBar({},{},{}) }
    )
}

@Composable
fun GoogleMapScreen(viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val uCuenca = com.google.android.gms.maps.model.LatLng(-2.9008975384128406, -79.01019314391168)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(uCuenca, 17f) }
    val properties = MapProperties(mapType = MapType.HYBRID)

    val model = MapviewModel()

    GoogleMap(cameraPositionState = cameraPositionState, properties = properties) {
        Marker(state = MarkerState(position = model.marker1))
        Marker(state = MarkerState(position = model.marker2))
        Marker(state = MarkerState(position = model.marker3))
        Marker(state = MarkerState(position = model.marker4))
        Marker(state = MarkerState(position = model.marker5))
    }
}

@Composable
fun MapBottomBar(placeClick: () -> Unit, routeClick: () -> Unit, parkClick: () -> Unit) {
    var placesColor by remember { mutableStateOf(Color.LightGray) }
    var routesColor by remember { mutableStateOf(Color.LightGray) }
    var parksColor by remember { mutableStateOf(Color.LightGray) }

    BottomAppBar(modifier = Modifier.fillMaxWidth(), backgroundColor = Color.White) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            BottomButton(
                painter = R.drawable.baseline_other_houses_24,
                text = "L. turisticos",
                color = placesColor
            )
            {
                placesColor = darkblue
                routesColor = Color.LightGray
                parksColor = Color.LightGray
                placeClick()
            }
            BottomButton(
                painter = R.drawable.baseline_alt_route_24,
                text = "Rutas",
                color = routesColor
            )
            {
                placesColor = Color.LightGray
                routesColor = Color.Red
                parksColor = Color.LightGray
                routeClick()
            }
            BottomButton(
                painter = R.drawable.baseline_park_24,
                text = "Parques",
                color = parksColor
            ) {
                placesColor = Color.LightGray
                routesColor = Color.LightGray
                parksColor = Color.Green
                parkClick()
            }
        }
    }
}

@Composable
fun BottomButton(painter: Int, text: String, color: Color, click: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable { click() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = painter),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color)
        )
        Text(
            text = text,
            fontSize = 15.sp,
            color = color,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(2.dp)
        )
    }
}