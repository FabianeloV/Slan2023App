package com.example.prototiposlan.screens

import com.example.prototiposlan.R

sealed class LatMenuScreens(val icon:Int,val title:String, val route:String) {

    object Ranking : LatMenuScreens(R.drawable.ic_baseline_arrow_forward_ios_24, "RANKING", "RankingScreen")

    object Reto : LatMenuScreens(R.drawable.baseline_directions_run_24, "RETO DEL DIA", "ChallengeScreen")

    object Muro : LatMenuScreens(R.drawable.baseline_forum_24, "MURO", "ForumScreen")

    object Mapa : LatMenuScreens(R.drawable.baseline_map_24, "MAPA", "MapScreen")

    object Flora : LatMenuScreens(R.drawable.baseline_park_24, "Flora y fauna", "PlantsScreen")

    object Album : LatMenuScreens(R.drawable.baseline_video_library_24, "Album", "AlbumScreen")
}

