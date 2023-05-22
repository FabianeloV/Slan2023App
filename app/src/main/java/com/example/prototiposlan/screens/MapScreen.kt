package com.example.prototiposlan.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(navController: NavController){
    Scaffold(
        topBar = { GeneralTopBar(title = "MAPAS", navController = navController)},
        content = ({ GoogleMapScreen()})
    )
}

@Composable
fun GoogleMapScreen() {
    val uCuenca = com.google.android.gms.maps.model.LatLng(-2.9008975384128406, -79.01019314391168)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(uCuenca, 10f)
    }

    GoogleMap(cameraPositionState = cameraPositionState)
}