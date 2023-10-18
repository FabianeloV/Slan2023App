package com.example.prototiposlan.screens

import android.content.ContentValues.TAG
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.darkgreen
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

    Scaffold(
        topBar = { GeneralTopBar(title = "Album fotográfico", navController = navController) },
        content = ({ AlbumContent { galleryLauncher.launch(ALL) } })
    )
    AddImageToFirestore(addImage = {downloadUrl -> viewModel.addImageUrl(downloadUrl) })
}

@Composable
fun AlbumContent(open: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "TEST",
            color = darkgreen,
            fontSize = 18.sp,
            fontFamily = graduateFont,
            modifier = Modifier.padding(4.dp)
        )

        AsyncImage(
            model = getAlbumUrl(),
            placeholder = painterResource(id = R.drawable.baseline_question_mark_24),
            error = painterResource(id = R.drawable.baseline_question_mark_24),
            contentDescription = "Album collage",
        )
        OpenGalleryButton { open() }
    }
}

@Composable
fun OpenGalleryButton(open: () -> Unit) {
    Button(onClick = { open() }) {
        Text(text = "Abrir Galeria")
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
fun getAlbumUrl():String{
    val avatarUrl = remember { mutableStateOf("") }

    val auth: FirebaseAuth = Firebase.auth
    val userId = auth.currentUser?.uid

    val db = FirebaseFirestore.getInstance()
    val docRef = db.collection("albumImages").document(userId.toString())

    docRef.addSnapshotListener{snapshot, e ->
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