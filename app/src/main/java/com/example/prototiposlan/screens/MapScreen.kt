package com.example.prototiposlan.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.prototiposlan.viewModels.MapviewModel
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(
    navController: NavController,
    viewModel: MapviewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Scaffold(
        topBar = { GeneralTopBar(title = "RUTAS", navController = navController) },
        content = ({ GoogleMapScreen(viewModel) })
    )
}

@Composable
fun GoogleMapScreen(coord: MapviewModel) {
    val uCuenca = com.google.android.gms.maps.model.LatLng(-2.9008975384128406, -79.01019314391168)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(uCuenca, 17f)
    }
    val properties = MapProperties(mapType = MapType.NORMAL)

    GoogleMap(cameraPositionState = cameraPositionState, properties = properties) {
        Marker(
            state = MarkerState(position = coord.route1Marker),
            title = "Ruta puertas del sol",
            snippet = "2.71 km -" + " 31.35 min -" + " 3.561 pasos",
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)
        )
        Polyline(
            points = coord.route1,
            color = Color.Blue
        )

        Marker(
            state = MarkerState(position = coord.route2Marker),
            title = "Ruta San Sebastian",
            snippet = "1 km -" + " 10 min -" + " 1.062 pasos",
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
        )
        Polyline(
            points = coord.route2,
            color = Color.Yellow
        )
        Marker(
            state = MarkerState(position = coord.route3Marker),
            title = "Ruta Paraiso",
            snippet = "2.9 km -" + " 34 min -" + " 7.281 pasos",
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
        )
        Polyline(
            points = coord.route3,
            color = Color.Green
        )
    }
}