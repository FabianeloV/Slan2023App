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

    val route1Marker = LatLng(-2.899864013365843, -79.00913600185727)
    val route1 = listOf(
        LatLng(-2.899864013365843, -79.00913600185727),
        LatLng(-2.8994877447620224, -79.00880379536997),
        LatLng(-2.8994408080727876, -79.00876351230536),
        LatLng(-2.8995158137788843, -79.0086736582987),
        LatLng(-2.899534565204833, -79.00864348344818),
        LatLng(-2.8995365742861643, -79.0086260490901),
        LatLng(-2.8995211713291904, -79.00859185092617),
        LatLng(-2.8994763018446257, -79.0085408889564),
        LatLng(-2.8994749624546037, -79.00853418342757),
        LatLng(-2.899442147457263, -79.00849931471141),
        LatLng(-2.8993524084800804, -79.00834575824985),
        LatLng(-2.899651234368603, -79.00783348886098),
        LatLng(-2.8998912973636948, -79.00748500097826),
        LatLng(-2.8992914321312835, -79.00733799110697),
        LatLng(-2.8992936603100476, -79.00732589013997),
        LatLng(-2.898277411868884, -79.00712805538136),
        LatLng(-2.8978457295108644, -79.00702635011547),
        LatLng(-2.897301267513782, -79.00694253108269),
        LatLng(-2.8975309175956, -79.00599291448535),
        LatLng(-2.897750644417521, -79.00498522565424),
        LatLng(-2.897632181875018, -79.00493026358158),
        LatLng(-2.897675780885577, -79.0048625233344),
        LatLng(-2.897634278083141, -79.0047613968302),
        LatLng(-2.8975040195745847, -79.00457172432313)
    )
}