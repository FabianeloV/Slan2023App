package com.example.prototiposlan.viewModels

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.time.LocalDate

class DaysViewModel : ViewModel() {

    private val mondayChallenge = arrayOf(
        "Realiza 10\n" + "saltos con\n" + "los pies \n" + "juntos donde\n" + "estés",
        "Realiza 10\n" + "abdominales\n" + "donde estés",
        "Realiza 10\n" + "burpees"
    )

    private val tuesdayChallenge = arrayOf(
        "Realiza 10\n" + "saltos con\n" + "tu pierna \n" + "dominante\n" + "donde estés",
        "manténte 10\n" + "segundos de\n" + "puntillas",
        "Rota tus\n" + "muñecas por\n" + "30 segundos"
    )

    private val wednesdayChallenge = arrayOf(
        "Realiza 10\n" + "saltos con\n" + "los pies \n" + "juntos donde\n" + "estés",
        "Realiza 10\n" + "abdominales\n" + "donde estés",
        "Camina 500\n" + "metros"
    )
    private val thursdayChallenge = arrayOf(
        "Mantenerse\n" + "5 segundos\n" + "en cuclillas \n" + "3 veces",
        "Realiza 10\n" + "saltos en\n" + "un pie",
        "Skipping\n" + "por 5\n" + "segundos"
    )
    private val fridayChallenge = arrayOf(
        "Realiza 10\n" + "saltos con\n" + "los pies \n" + "juntos donde\n" + "estés",
        "Realiza 10\n" + "abdominales\n" + "donde estés",
        "Camina en\n" + "un parque"
    )

    val stepCounter = mutableStateOf(0)
    private fun getDay(): String {
        val today = LocalDate.now()
        val dayOfWeek = today.dayOfWeek
        return dayOfWeek.toString()
    }

    fun getTranslatedDay(day: String = getDay()): String {
        return when (day) {
            "MONDAY" -> "Lunes"
            "TUESDAY" -> "Martes"
            "WEDNESDAY" -> "Miércoles"
            "THURSDAY" -> "Jueves"
            "FRIDAY" -> "Viernes"
            "SATURDAY" -> "Sábado"
            "SUNDAY" -> "Domingo"

            else -> { "Reto" }
        }
    }

    fun getChallenge(day: String = getDay()): Array<String> {
        return when (day) {
            "MONDAY" -> mondayChallenge
            "TUESDAY" -> tuesdayChallenge
            "WEDNESDAY" -> wednesdayChallenge
            "THURSDAY" -> thursdayChallenge
            "FRIDAY" -> fridayChallenge

            else -> { wednesdayChallenge }
        }
    }

    fun sumTwentyPoints() {
        val auth: FirebaseAuth = Firebase.auth
        val userId = auth.currentUser?.uid

        val db = FirebaseFirestore.getInstance()
        val docRef = db.collection("users").document(userId.toString())

        docRef.update("points", FieldValue.increment(20))
            .addOnSuccessListener { Log.d(ContentValues.TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(ContentValues.TAG, "Error writing document", e) }

    }
}