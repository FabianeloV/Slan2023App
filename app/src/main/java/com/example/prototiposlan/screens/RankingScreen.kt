package com.example.prototiposlan.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

@Composable
fun RankingScreen(navController: NavController) {
    Scaffold(
        topBar = { GeneralTopBar(title = "Ranking", navController = navController) },
        content = ({ Boton() })
    )


}

@Composable
fun Boton() {
    Column(Modifier.fillMaxSize()) {
        Button(onClick = { sumTenPoints() }) {
            Text(text = "Prueba")
        }
    }
}

fun sumTenPoints() {
    val auth: FirebaseAuth = Firebase.auth
    val userId = auth.currentUser?.uid

    val db = FirebaseFirestore.getInstance()
    val docRef = db.collection("users").document(userId.toString())

    docRef.update("points", FieldValue.increment(10)).addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
        .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }

}


