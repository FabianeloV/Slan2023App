package com.example.prototiposlan.screens


import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.prototiposlan.R
import com.example.prototiposlan.ui.theme.darkgreen
import com.example.prototiposlan.ui.theme.darkorange
import com.example.prototiposlan.ui.theme.graduateFont
import com.example.prototiposlan.viewModels.RankingFields
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.delay

@Composable
fun RankingScreen(navController: NavController) {

    val test = getUsersRanking()

    val loading = remember { mutableStateOf(true) }

    LaunchedEffect(key1 = true) {
        delay(3000)
        loading.value = false
    }

    Scaffold(
        topBar = { GeneralTopBar(title = "Ranking", navController = navController) },
        content = ({
            if (loading.value) {
                CircularProgress()
            } else {
                RankingContent(list = test)
            }
        })
    )
}

@Composable
fun RankingContent(list: List<RankingFields>) {
    Column(modifier = Modifier.fillMaxSize()) {
        val user = RankingFields(
            nickname = getNickname(),
            avatar = getAvatarUrl(),
            points = points().toLong()
        )
        UserCard(user)

        Spacer(modifier = Modifier.padding(top = 16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
                .background(color = darkorange)
                .padding(top = 20.dp)
        )
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .background(color = darkorange)
                .padding(top = 20.dp)
        )

        LazyColumn {
            item { list.subList(0, 10).forEach { rank -> UserCard(rank) } }
        }
    }
}

@Composable
fun UserCard(rank: RankingFields) {
    Card(elevation = 6.dp, modifier = Modifier.padding(top = 15.dp), shape = CircleShape) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = rank.avatar,
                placeholder = painterResource(id = R.drawable.usericon),
                error = painterResource(id = R.drawable.usericon),
                contentDescription = rank.nickname,
                modifier = Modifier.size(80.dp).clip(CircleShape).border(1.dp, color = darkgreen, shape = CircleShape)
            )

            Text(text = rank.nickname, fontFamily = graduateFont, fontSize = 24.sp)

            Text(
                text = "${rank.points} pts",
                fontFamily = graduateFont,
                fontSize = 24.sp,
                color = darkorange
            )
        }
    }
}

@Composable
fun getUsersRanking(): List<RankingFields> {
    val db = FirebaseFirestore.getInstance()

    val rankingList = remember { mutableListOf<RankingFields>() }

    db.collection("users").orderBy("points", Query.Direction.DESCENDING)
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {
                val chat = RankingFields(
                    nickname = document.data["nickname"].toString().split(" ")[0],
                    avatar = document.data["avatar"].toString(),
                    points = document.data["points"] as Long
                )
                rankingList.add(chat)
            }
            Log.d(ContentValues.TAG, "$rankingList")
        }
        .addOnFailureListener { exception ->
            Log.d(ContentValues.TAG, "Error getting documents: ", exception)
        }
    return rankingList
}