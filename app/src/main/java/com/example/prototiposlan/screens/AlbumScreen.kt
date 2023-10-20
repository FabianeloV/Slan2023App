package com.example.prototiposlan.screens

import android.content.ContentValues.TAG
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.Shapes
import com.example.prototiposlan.ui.theme.darkgreen
import com.example.prototiposlan.ui.theme.gold
import com.example.prototiposlan.ui.theme.graduateFont
import com.example.prototiposlan.viewModels.AlbumViewModel
import com.example.prototiposlan.viewModels.Response
import com.example.prototiposlan.viewModels.consts.ALL
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

@Composable
fun AlbumScreen(navController: NavController, viewModel: AlbumViewModel = hiltViewModel()) {

    val galleryLauncher = rememberLauncherForActivityResult(contract = GetContent()) { imageUri ->
        imageUri?.let { viewModel.uploadImageToStorage(imageUri) }
    }

    val dialogState = remember { mutableStateOf(false) }

    Scaffold(
        topBar = { GeneralTopBar(title = "Album", navController = navController){dialogState.value = true } },
        content = ({ AlbumContent { galleryLauncher.launch(ALL) } })
    )
    AddImageToFirestore(addImage = { downloadUrl -> viewModel.addImageUrl(downloadUrl) })

    if (dialogState.value) {
        DialogInfo(close = { dialogState.value = false }, title = "Información del Álbum", text = "Los usuarios pueden subir UNA foto de su preferencia para evidenciar su experiencia durante el congreso. Los organizadores del SLAN 2023 realizarán un concurso entre las mejores fotografías para posteriormente premiar a los ganadores. EL USO DE ESTAS FOTOGRAFÍAS RADICA EXCLUSIVAMENTE DE FORMA INTERNA, NINGUNA DE LAS FOTOGRAFÍAS OBTENIDAS SERÁ PUBLICADA EN NINGÚN MEDIO PÚBLICO O SOCIAL")
    }
}

@Composable
fun AlbumContent(open: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .border(shape = Shapes.small, border = BorderStroke(2.dp, color = darkgreen))
    ) {
        AsyncImage(
            model = getAlbumUrl(),
            placeholder = painterResource(id = R.drawable.baseline_panorama_24),
            error = painterResource(id = R.drawable.baseline_panorama_24),
            contentDescription = "Album collage",
            modifier = Modifier
                .clip(Shapes.small)
                .size(width = 300.dp, height = 500.dp)
                .border(1.dp, color = darkgreen, shape = Shapes.small)
        )

        OpenGalleryButton { open() }
    }
}

@Composable
fun OpenGalleryButton(open: () -> Unit) {
    OutlinedButton(
        onClick = { open() },
        colors = ButtonDefaults.buttonColors(backgroundColor = gold),
        shape = CircleShape
    ) {
        Text(
            text = "SUBIR FOTO",
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = graduateFont
        )

        Spacer(modifier = Modifier.padding(5.dp))

        Icon(imageVector = Icons.Outlined.KeyboardArrowUp, contentDescription = null)
    }
}

@Composable
fun AddImageToFirestore(
    viewModel: AlbumViewModel = hiltViewModel(),
    addImage: (downloadUrl: Uri) -> Unit
) {
    when (val response = viewModel.uploadImageState) {
        is Response.Loading -> CircularProgress()
        is Response.Succes -> response.data?.let { downloadUrl ->
            LaunchedEffect(downloadUrl) { addImage(downloadUrl) }
        }

        is Response.Failure -> print(response.e)
    }
}

@Composable
fun getAlbumUrl(): String {
    val avatarUrl = remember { mutableStateOf("") }

    val auth: FirebaseAuth = Firebase.auth
    val userId = auth.currentUser?.uid

    val db = FirebaseFirestore.getInstance()
    val docRef = db.collection("albumImages").document(userId.toString())

    docRef.addSnapshotListener { snapshot, e ->
        if (e != null) {
            Log.w(TAG, "Listen failed.", e)
            return@addSnapshotListener
        }
        if (snapshot != null && snapshot.exists()) {
            avatarUrl.value = snapshot.data!!["url"].toString()
        } else {
            Log.d(TAG, "Current data: null")
        }
    }
    return avatarUrl.value
}