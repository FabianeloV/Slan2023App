package com.example.prototiposlan

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prototiposlan.screens.ChallengeScreen
import com.example.prototiposlan.screens.ForumScreen
import com.example.prototiposlan.screens.HomeScreen
import com.example.prototiposlan.screens.LoginScreen
import com.example.prototiposlan.screens.MapScreen
import com.example.prototiposlan.screens.RegisterScreen
import com.example.prototiposlan.screens.Splash
import com.example.prototiposlan.screens.UserScreen

class MainActivity : ComponentActivity(), SensorEventListener {

    private var sensorManager:SensorManager?=null
    private var running = false
    private var steps = 0f
    private val code = 100
    private val daysViewModel = DaysViewModel()
    private val runningQOrLater = Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main(daysViewModel.stepCounter.value)
        }
        if (isPermissionGranted()) {
            requestPermission()
        }
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }
    override fun onResume() {
        super.onResume()
        running = true
        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepSensor == null){
            Toast.makeText(this, "No se detecta un sensor de pasos",Toast.LENGTH_SHORT).show()
        }else{
            sensorManager?.registerListener(this,stepSensor, SensorManager.SENSOR_DELAY_FASTEST)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (running){
            steps = event!!.values[0]
            daysViewModel.stepCounter.value = steps.toInt()
        }
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
    @SuppressLint("InlinedApi")
    private fun requestPermission() {
        if (runningQOrLater) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACTIVITY_RECOGNITION),
                code
            )
        }
    }
    @SuppressLint("InlinedApi")
    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.ACTIVITY_RECOGNITION
        ) != PackageManager.PERMISSION_GRANTED
    }

}
@Composable
fun Main(steps:Int){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SplashScreen"){
        composable(route = "SplashScreen"){ Splash(navController)}
        composable(route = "LoginScreen"){ LoginScreen(navController)}
        composable(route = "RegisterScreen"){ RegisterScreen(navController)}
        composable(route = "HomeScreen"){ HomeScreen(navController)}
        composable(route = "UserScreen"){ UserScreen(navController, steps)}
        composable(route = "ForumScreen"){ ForumScreen(navController)}
        composable(route= "MapScreen"){ MapScreen(navController)}
        composable(route = "ChallengeScreen"){ ChallengeScreen(navController)}
    }
}