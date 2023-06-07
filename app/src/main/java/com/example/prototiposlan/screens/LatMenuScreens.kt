package com.example.prototiposlan.screens

import com.example.prototiposlan.R


sealed class LatMenuScreens(val icon:Int,val title:String, val route:String) {

    object Usuario : LatMenuScreens(R.drawable.baseline_account_box_24, "USUARIO", "UserScreen")

    object Ranking : LatMenuScreens(R.drawable.ic_baseline_arrow_forward_ios_24, "RANKING", "")

    object Reto : LatMenuScreens(R.drawable.baseline_directions_run_24, "RETO DEL DIA", "ChallengeScreen")

    object Muro : LatMenuScreens(R.drawable.baseline_forum_24, "MURO", "ForumScreen")

    object Ejercicios : LatMenuScreens(R.drawable.baseline_park_24, "EJERCICIOS","")

    object Rutinas : LatMenuScreens(R.drawable.baseline_other_houses_24,"RUTINAS","")

    object Tabla : LatMenuScreens(R.drawable.baseline_park_24, "TABLA CALÓRICA", "")

    object Mapa : LatMenuScreens(R.drawable.baseline_map_24, "MAPA", "MapScreen")

    object Plantas : LatMenuScreens(R.drawable.baseline_alt_route_24,"FLORA Y FAUNA","")
}

