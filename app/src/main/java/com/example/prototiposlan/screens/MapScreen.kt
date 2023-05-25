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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.darkblue
import com.example.prototiposlan.viewModels.MapviewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(navController: NavController) {
    val model = MapviewModel()
    var mapMarkerValue by remember { mutableStateOf(0) }
    Scaffold(
        topBar = { GeneralTopBar(title = "MAPAS", navController = navController) },
        content = ({ GoogleMapScreen(model, mapMarkerValue) }),
        bottomBar = { MapBottomBar({mapMarkerValue=1}, {mapMarkerValue=2}, {mapMarkerValue=3}) }
    )
}

@Composable
fun GoogleMapScreen(coord:MapviewModel,mapMarkerValue:Int) {
    val uCuenca = com.google.android.gms.maps.model.LatLng(-2.9008975384128406, -79.01019314391168)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(uCuenca, 17f)
    }
    val properties = MapProperties(mapType = MapType.NORMAL)

    GoogleMap(cameraPositionState = cameraPositionState, properties = properties) {
        when (mapMarkerValue) {
            1 -> {
                Marker(state = MarkerState(position = coord.placeMarker1))
                Marker(state = MarkerState(position = coord.placeMarker2))
                Marker(state = MarkerState(position = coord.placeMarker3))
                Marker(state = MarkerState(position = coord.placeMarker4))
                Marker(state = MarkerState(position = coord.placeMarker5))
            }
            2 ->{
                Polyline(points = listOf(
                    coord.polyline1,
                    coord.polyline2,
                    coord.polyline3,
                    coord.polyline4,
                    coord.polyline5,
                    coord.polyline6,
                    coord.polyline7,
                    coord.polyline8,
                    coord.polyline9,
                    coord.polyline10,
                    coord.polyline11,
                    coord.polyline12,
                    coord.polyline13,
                    coord.polyline14
                ),
                    color = Color.Red
                )
            }
            3->{
                Marker(state = MarkerState(position = coord.parkMarker1))
                Marker(state = MarkerState(position = coord.parkMarker2))
                Marker(state = MarkerState(position = coord.parkMarker3))
                Marker(state = MarkerState(position = coord.parkMarker4))
                Marker(state = MarkerState(position = coord.parkMarker5))
            } else -> {

            }
        }
    }
}

@Composable
fun MapBottomBar(placeClick: () -> Unit, routeClick: () -> Unit, parkClick: () -> Unit) {
    var placesColor by remember { mutableStateOf(Color.LightGray) }
    var routesColor by remember { mutableStateOf(Color.LightGray) }
    var parksColor by remember { mutableStateOf(Color.LightGray) }

    BottomAppBar(modifier = Modifier.fillMaxWidth(), backgroundColor = Color.White, elevation = 1.dp) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            BottomButton(
                painter = R.drawable.baseline_other_houses_24,
                text = "L. turísticos",
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