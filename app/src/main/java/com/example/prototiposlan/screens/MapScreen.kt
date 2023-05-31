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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.graduateFont
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
fun MapScreen(navController: NavController, viewModel: MapviewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {

    Scaffold(
        topBar = { GeneralTopBar(title = "MAPAS", navController = navController) },
        content = ({ GoogleMapScreen(viewModel, viewModel.mapMarkerValue) }),
        bottomBar = { MapBottomBar(viewModel) }
    )
}

@Composable
fun GoogleMapScreen(coord:MapviewModel,mapMarkerValue:Int) {
    val uCuenca = com.google.android.gms.maps.model.LatLng(-2.9008975384128406, -79.01019314391168)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(uCuenca, 17f) }
    val properties = MapProperties(mapType = MapType.HYBRID)

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
                Polyline(points = coord.route1,
                    color = Color.Red
                )
            }
            3->{
                Marker(state = MarkerState(position = coord.parkMarker1))
                Marker(state = MarkerState(position = coord.parkMarker2))
                Marker(state = MarkerState(position = coord.parkMarker3))
                Marker(state = MarkerState(position = coord.parkMarker4))
                Marker(state = MarkerState(position = coord.parkMarker5))
            }
        }
    }
}

@Composable
fun MapBottomBar(viewModel: MapviewModel) {
    BottomAppBar(modifier = Modifier.fillMaxWidth(), backgroundColor = Color.White, elevation = 1.dp) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            BottomButton(
                painter = R.drawable.baseline_other_houses_24,
                text = "L. turísticos",
                color = viewModel.placeColor
            )
            {
               viewModel.placeClick()
            }
            BottomButton(
                painter = R.drawable.baseline_alt_route_24,
                text = "Rutas",
                color = viewModel.routeColor
            )
            {
                viewModel.routeClick()
            }
            BottomButton(
                painter = R.drawable.baseline_park_24,
                text = "Parques",
                color = viewModel.parkColor
            ) {
                viewModel.parkClick()
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
            fontFamily = graduateFont,
            color = color,
            modifier = Modifier.padding(2.dp)
        )
    }
}