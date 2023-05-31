package com.example.prototiposlan.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.prototiposlan.ui.theme.darkblue
import com.google.android.gms.maps.model.LatLng

class MapviewModel : ViewModel() {
    var mapMarkerValue by mutableStateOf(0)

    var placeColor by mutableStateOf(Color.LightGray)
    var routeColor by mutableStateOf(Color.LightGray)
    var parkColor by mutableStateOf(Color.LightGray)

    fun placeClick(){
        placeColor = darkblue
        routeColor = Color.LightGray
        parkColor = Color.LightGray
        mapMarkerValue = 1
    }
    fun routeClick(){
        placeColor = Color.LightGray
        routeColor = Color.Red
        parkColor = Color.LightGray
        mapMarkerValue = 2
    }
    fun parkClick(){
        placeColor = Color.LightGray
        routeColor = Color.LightGray
        parkColor = Color.Green
        mapMarkerValue = 3
    }

    val parkMarker1 = LatLng(-2.904450177064454, -79.00343787073638)
    val parkMarker2 = LatLng(-2.9132805183659776, -79.01212910045729)
    val parkMarker3 = LatLng(-2.9096086431301273, -78.98726886557903)
    val parkMarker4 = LatLng(-2.919608643130127, -78.98726886557903)
    val parkMarker5 = LatLng(-2.8973674511436607, -79.00425070881073)

    val placeMarker1 = LatLng(-2.896126147894531, -79.01139408398703)
    val placeMarker2 = LatLng(-2.8977700663097528, -79.00655751155541)
    val placeMarker3 = LatLng(-2.901528654540669, -79.00416919314323)
    val placeMarker4 = LatLng(-2.906052619971552, -78.99688950146859)
    val placeMarker5 = LatLng(-2.8981078402088922, -79.00663796137042)

    val route1 = listOf(
        LatLng(-2.8989488309269698, -79.0106139551607),
        LatLng(-2.899822772174957, -79.01171356918785),
        LatLng(-2.9004247895713715, -79.01216942415265),
        LatLng(-2.9008602749565746, -79.01166442904963),
        LatLng(-2.9011038488084906, -79.01161159237157),
        LatLng(-2.902355293002172, -79.01216526516727),
        LatLng(-2.902977867094535, -79.0114385156128),
        LatLng(-2.903667194387417, -79.01045000008725),
        LatLng(-2.902945472706862, -79.0098811635117),
        LatLng(-2.9023582462496966, -79.00950345030371),
        LatLng(-2.902130667287927, -79.0093972205116),
        LatLng(-2.901913084035158, -79.00878866858709),
        LatLng(-2.900886632922395, -79.00802302764733),
        LatLng(-2.8989488309269698, -79.0106139551607)
    )
}