package com.example.prototiposlan.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.collectAsState
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
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.prototiposlan.DataStore
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.darkgreen
import com.example.prototiposlan.ui.theme.graduateFont
import com.example.prototiposlan.viewModels.Plants
import com.example.prototiposlan.viewModels.PlantsViewmodel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PlantsScreen(
    navController: NavController,
    plantsViewmodel: PlantsViewmodel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val context = LocalContext.current

    val loading = remember { mutableStateOf(true) }

    val plantslist = remember { plantsViewmodel.getPlantList(context) }

    val dataStore = DataStore(context)

    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        delay(900)
        loading.value = false
    }

    val dialogState = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            GeneralTopBar(
                title = "Flora",
                navController = navController
            ) { dialogState.value = true }
        },
        content = ({
            if (loading.value) {
                CircularProgress()
            } else {
                PlantsContent(plantslist, dataStore, scope) { plantsViewmodel.sumTwentyPoints() }
            }
        })
    )

    if (dialogState.value) {
        DialogInfo(
            close = { dialogState.value = false },
            title = "Información de la Flora",
            text = "La universidad de Cuenca posee una alta variedad de flora en sus instalaciones. Algunas de estas poseen tarjetas con su nombre y un código que pueden ingresar para ganar puntos."
        )

    }


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
fun PlantsContent(
    plantList: MutableList<Plants>,
    dataStore: DataStore,
    scope: CoroutineScope,
    click: () -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item { plantList.forEach { plant -> PlantCard(plant, dataStore, scope) { click() } } }
    }
}

@Composable
fun PlantCard(plants: Plants, dataStore: DataStore, scope: CoroutineScope, click: () -> Unit) {
    val code = rememberSaveable { mutableStateOf("") }

    val plantState = booleanPreferencesKey(plants.id.toString())

    val savedPlantState = dataStore.getPlantState(plantState).collectAsState(initial = false)

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

                        if (savedPlantState.value!!) {
                            Box(
                                modifier = Modifier
                                    .padding(top = 20.dp)
                                    .border(width = 2.dp, color = darkgreen, shape = CircleShape)
                            ) {
                                Text(
                                    text = "Encontrada",
                                    fontFamily = graduateFont,
                                    fontSize = 24.sp,
                                    color = darkgreen,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }

                        } else {
                            OutlinedTextField(
                                value = code.value,
                                onValueChange = { code.value = it },
                                label = { Text(text = "Ingresar código") },
                                modifier = Modifier.size(height = 60.dp, width = 150.dp),
                                shape = CircleShape
                            )
                            if (code.value == plants.code) {
                                IconButton(
                                    onClick = {
                                        scope.launch { dataStore.savePlantState(plantState) }
                                        click()
                                    },
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