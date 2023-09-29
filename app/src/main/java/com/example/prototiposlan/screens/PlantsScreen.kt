package com.example.prototiposlan.screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.graduateFont
import com.example.prototiposlan.viewModels.Plants
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.io.IOException

@Composable
fun PlantsScreen(navController: NavController) {
    val context = LocalContext.current
    Scaffold(
        topBar = { GeneralTopBar(title = "Flora y fauna", navController = navController) },
        content = ({ PlantsContent(getPlantList(context)) })
    )
}

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

@Composable
fun PlantsContent(plantList: List<Plants>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item { plantList.forEach { plant -> PlantCard(plant) } }
    }
}

@Composable
fun PlantCard(plants: Plants) {

    val code = rememberSaveable { mutableStateOf("") }

    Card(elevation = 6.dp, modifier = Modifier.padding(top = 5.dp)) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(verticalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = plants.name.toString(), fontSize = 16.sp, fontFamily = graduateFont)
                    Text(
                        text = plants.cientific.toString(),
                        fontFamily = graduateFont,
                        color = Color.DarkGray
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        OutlinedTextField(
                            value = code.value,
                            onValueChange = { code.value = it },
                            label = { Text(text = "Ingresar código") },
                            modifier = Modifier.size(height = 60.dp, width = 150.dp),
                            shape = CircleShape
                        )
                        if (code.value == plants.code) {
                            IconButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .padding(start = 6.dp)
                                    .border(width = 1.dp, color = Color.Green, shape = CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.ArrowForward,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }
                AsyncImage(
                    model = plants.url,
                    placeholder = painterResource(id = R.drawable.baseline_question_mark_24),
                    error = painterResource(id = R.drawable.baseline_question_mark_24),
                    contentDescription = plants.id.toString(),
                    modifier = Modifier.size(105.dp)
                )
            }
        }
    }
}