package com.example.prototiposlan.viewModels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.IOException

data class Plants(
    @SerializedName("id") @Expose var id: Int? = null,
    @SerializedName("nombre") @Expose var name: String? = null,
    @SerializedName("nCientifico") @Expose var cientific: String? = null,
    @SerializedName("funcion") @Expose var funct: String? = null,
    @SerializedName("curioso") @Expose var data: String? = null,
    @SerializedName("codigo") @Expose var code: String? = null,
    @SerializedName("url") @Expose var url: String? = null
)

class PlantsViewmodel:ViewModel() {
    fun getPlantList(context: Context): List<Plants> {

        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("Plantas.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            Log.d("PLANTS JSON", ioException.toString())
        }

        val listCountryType = object : TypeToken<List<Plants>>() {}.type
        return Gson().fromJson(jsonString, listCountryType)
    }
}
