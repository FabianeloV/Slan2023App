package com.example.prototiposlan.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class ForumViewModel: ViewModel() {
    fun addForumChat(nickName: String, text: String) {
        val userField = ForumFields(
            nickname = nickName,
            text = text
        ).forumMap()

        FirebaseFirestore.getInstance().collection("forum")
            .document()
            .set(userField)
            .addOnSuccessListener { Log.d("userField", "creado $it") }
            .addOnFailureListener { Log.d("userField", "error $it") }

    }
}