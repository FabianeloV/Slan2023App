package com.example.prototiposlan.authenticationFiles


sealed class SingInValues(var mailValue:String, var passwordValue: String, var repeatedPassword:String){
    object SingInParameters: SingInValues("","","")

    object LogInParameters: SingInValues("","","")
}
