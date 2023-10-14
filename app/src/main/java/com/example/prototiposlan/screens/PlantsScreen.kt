package com.example.prototiposlan.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.darkgreen
import com.example.prototiposlan.ui.theme.graduateFont
import com.example.prototiposlan.viewModels.Plants
import com.example.prototiposlan.viewModels.PlantsViewmodel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay

@Composable
fun PlantsScreen(
    navController: NavController,
    plantsViewmodel: PlantsViewmodel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val context = LocalContext.current

    val loading = remember { mutableStateOf(true) }

    val list = getPlantStates()

    LaunchedEffect(key1 = true) {
        delay(6000)
        loading.value = false
    }

    Scaffold(
        topBar = { GeneralTopBar(title = "Flora", navController = navController) },
        content = ({
            if (loading.value) {
                CircularProgress()
            } else {
                PlantsContent(plantsViewmodel.getPlantList(context), list)
            }
        })
    )
}

@Composable
fun CircularProgress() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = darkgreen
        )
    }
}


@Composable
fun getPlantStates(): List<Boolean> {
    val auth: FirebaseAuth = Firebase.auth
    val userId = auth.currentUser?.uid
    val db = FirebaseFirestore.getInstance()
    val docRef = db.collection("plantstates").document(userId.toString())

    var plantsStates = remember { listOf<Boolean>() }

    docRef.get().addOnSuccessListener { document ->
        val test = document.data?.get("encountered") as List<Boolean>

        plantsStates = test
        Log.d(TAG, "document ${plantsStates}")
    }
        .addOnFailureListener { exception ->
            Log.d(TAG, "get failed with ", exception)
        }

    return plantsStates
}

@Composable
fun PlantsContent(plantList: MutableList<Plants>, list: List<Boolean>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item { plantList.forEach { plant -> PlantCard(plant, list) } }
    }
}

@Composable
fun PlantCard(plants: Plants, List: List<Boolean>) {
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
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(verticalArrangement = Arrangement.SpaceEvenly) {
                    Text(
                        text = plants.name.toString(),
                        fontSize = 16.sp,
                        fontFamily = graduateFont
                    )
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
                                onClick = { },
                                modifier = Modifier
                                    .padding(start = 6.dp)
                                    .border(
                                        width = 1.dp,
                                        color = Color.Green,
                                        shape = CircleShape
                                    )
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.ArrowForward,
                                    contentDescription = null
                                )
                            }
                        }
                        if (List[plants.id]) {
                            Text(text = "hola")
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