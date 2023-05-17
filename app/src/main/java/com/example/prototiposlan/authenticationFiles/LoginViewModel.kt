package com.example.prototiposlan.authenticationFiles

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    val auth:FirebaseAuth = Firebase.auth
    val loading = MutableLiveData(false)

    fun singIn(email:String, password:String, navigate:()->Unit)
    =viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful){
                        navigate()
                        Log.d("Logueo","Logueo satisfactorio")
                    } else{
                        Log.d("Logueo","Error de logueo: ${task.result}")
                    }
                }
        } catch (ex:Exception){
            Log.d("Logueo","Error de logueo: ${ex.message}")
        }
    }
}