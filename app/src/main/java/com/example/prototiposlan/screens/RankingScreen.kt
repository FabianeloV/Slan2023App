package com.example.prototiposlan.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.navigation.NavController
import com.example.prototiposlan.DataStore
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

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
        
        val tedt = listOf(0,1,2)

        val ostias = booleanPreferencesKey(tedt[2].toString())

        val ostia = booleanPreferencesKey(tedt[1].toString())

        val context = LocalContext.current

        val store = DataStore(context)

        val savedText = "holaaaaa"
        
        val savedBool = store.getPlantState(ostia).collectAsState(initial = false)

        val savedBools = store.getPlantState(ostias).collectAsState(initial = false)

        val scope = rememberCoroutineScope()

        val text = remember { mutableStateOf("") }

        Button(onClick = { scope.launch { store.savePlantState(ostia) }}) {
            Text(text = "Prueba")
        }

        TextField(value = text.value, onValueChange = {text.value = it})
        
        Spacer(modifier = Modifier.padding(20.dp))
        
        if (savedBool.value!!){
            Text(text = savedText)
        }

        Button(onClick = { scope.launch { store.savePlantState(ostias) }}) {
            Text(text = "Prueba 2")
        }

        if (savedBools.value!!){
            Text(text = savedText)
        }


    }
}


