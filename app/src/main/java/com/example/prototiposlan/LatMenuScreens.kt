package com.example.prototiposlan

sealed class LatMenuScreens(val icon:Int,val title:String, val route:String) {

    object Usuario : LatMenuScreens(R.drawable.ic_baseline_account_box_24, "USUARIO", "")
    object Muro : LatMenuScreens(R.drawable.ic_baseline_forum_24, "MURO", "")
    object Presentaciones :
        LatMenuScreens(R.drawable.ic_baseline_video_library_24, "PRESENTACIONES", "")

    object Mapa : LatMenuScreens(R.drawable.ic_baseline_map_24, "MAPA", "")
}

