package com.example.prototiposlan


sealed class SingInValues(var mailValue:String, var passwordValue: String, var repeatedPassword:String){
    object SingInParameters:SingInValues("","","")

    object LogInParameters:SingInValues("","","")
}
