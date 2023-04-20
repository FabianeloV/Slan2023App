package com.example.prototiposlan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prototiposlan.Screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }
    }
}

@Composable
fun Main(){
   val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SplashScreen"){
        composable(route = "SplashScreen"){ Splash(navController) }
        composable(route = "LoginScreen"){ LoginScreen(navController) }
        composable(route = "RegisterScreen"){ RegisterScreen(navController) }
        composable(route = "HomeScreen"){ HomeScreen(navController) }
        composable(route = "UserScreen"){ UserScreen(navController) }
    }

}





