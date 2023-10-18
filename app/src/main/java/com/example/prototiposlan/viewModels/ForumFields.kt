package com.example.prototiposlan.viewModels

data class ForumFields(
    val nickname: String,
    val text: String,
) {
    fun forumMap(): MutableMap<String, Any> {
        return mutableMapOf(
            "nickname" to this.nickname,
            "text" to this.text
        )
    }
}

