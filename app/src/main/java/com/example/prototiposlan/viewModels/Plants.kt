package com.example.prototiposlan.viewModels

import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.common.reflect.TypeToken
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.IOException

data class Plants(
    @SerializedName("id") @Expose var id: Int = 0,
    @SerializedName("nombre") @Expose var name: String? = null,
    @SerializedName("nCientifico") @Expose var cientific: String? = null,
    @SerializedName("funcion") @Expose var funct: String? = null,
    @SerializedName("curioso") @Expose var data: String? = null,
    @SerializedName("codigo") @Expose var code: String? = null,
    @SerializedName("url") @Expose var url: String? = null,
)

class PlantsViewmodel:ViewModel() {
    fun getPlantList(context: Context): MutableList<Plants> {

        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("Plantas.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            Log.d("PLANTS JSON", ioException.toString())
        }

        val listPlantType = object : TypeToken<List<Plants>>() {}.type

        return Gson().fromJson(jsonString, listPlantType)
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
