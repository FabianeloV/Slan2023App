package com.example.prototiposlan.screens

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prototiposlan.ui.theme.darkgreen
import com.example.prototiposlan.ui.theme.graduateFont
import com.example.prototiposlan.viewModels.ForumViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

@Composable
fun ForumScreen(
    navController: NavController,
    forumViewModel: ForumViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Scaffold(
        topBar = { GeneralTopBar(title = "MURO", navController = navController) },
        content = ({ ForumChatCard()}),
        bottomBar = ({ ForumUpload(forumViewModel, getNickname()) })
    )
    GetForumChats()
}

@Composable
fun ForumUpload(forumViewModel: ForumViewModel, nickname: String) {
    val text = rememberSaveable { mutableStateOf("") }
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.White,
        elevation = 1.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp), horizontalArrangement = Arrangement.SpaceAround
        ) {

            OutlinedTextField(
                value = text.value,
                onValueChange = { text.value = it },
                shape = CircleShape,
                modifier = Modifier
                    .width(300.dp)
                    .border(color = darkgreen, width = 2.dp, shape = CircleShape)
            )

            Button(
                onClick = {
                    forumViewModel.addForumChat(nickname, text.value)
                    text.value = ""
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = darkgreen),
                shape = RoundedCornerShape(3.dp)
            ) {
                Icon(
                    Icons.Outlined.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun ForumChatCard() {
    Card(elevation = 6.dp, modifier = Modifier.padding(top = 15.dp), shape = CircleShape) {
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
                        text = "Fabian verdesoto",
                        fontFamily = graduateFont
                    )
                    Text(
                        text = "Me gusto mucho el congreso. ojala estar la proxima edicion",
                        fontFamily = graduateFont,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun GetForumChats() {
    val db = FirebaseFirestore.getInstance()

    db.collection("forum")
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {
                val nick = document.data["nickname"]
                val text = document.data["text"]
                Log.d(TAG, "${document.id} => nombre $nick y texto $text")
            }
        }
        .addOnFailureListener { exception ->
            Log.d(TAG, "Error getting documents: ", exception)
        }
}