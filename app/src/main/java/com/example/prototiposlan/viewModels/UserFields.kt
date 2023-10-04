package com.example.prototiposlan.viewModels

data class UserFields(
    val id:String,
    val nickname:String,
    val avatar:String,
    val points:Int,
    val age:String
){
    fun userMap():MutableMap<String,Any>{
        return mutableMapOf(
            "id" to this.id,
            "nickname" to this.nickname,
            "avatar" to this.avatar,
            "points" to this.points,
            "age" to this.age
        )
    }
}
