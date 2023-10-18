package com.example.prototiposlan.viewModels

import com.google.firebase.Timestamp

data class ForumFields(
    var nickname: String,
    var text: String,
    var time: Timestamp?
) {
    fun forumMap(): MutableMap<String, Any?> {
        return mutableMapOf(
            "nickname" to this.nickname,
            "text" to this.text,
            "time" to this.time
        )
    }
}
