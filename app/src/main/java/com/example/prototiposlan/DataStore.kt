package com.example.prototiposlan

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStore(private val context: Context) {

    // to make sure there is only one instance
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("PlantStates")
    }
    // to get the email
    fun getPlantState(test: Preferences.Key<Boolean>):Flow<Boolean?>{
        val getBool: Flow<Boolean?> = context.dataStore.data.map { prefrences ->
            prefrences[test] ?: false
        }
        return getBool
    }
    // to save the email
    suspend fun savePlantState(test: Preferences.Key<Boolean>) {
        context.dataStore.edit { preferences ->
            preferences[test] = true
        }
    }
}