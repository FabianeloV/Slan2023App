package com.example.prototiposlan.viewModels

data class UserFields(
    val id:String,
    val nickname:String,
    val avatar:String,
    val points:Int
){
    fun userMap():MutableMap<String,Any>{
        return mutableMapOf(
            "id" to this.id,
            "nickname" to this.nickname,
            "avatar" to this.avatar,
            "points" to this.points
        )
    }
}
