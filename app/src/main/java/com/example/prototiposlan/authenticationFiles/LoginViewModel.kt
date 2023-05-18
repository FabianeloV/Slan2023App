package com.example.prototiposlan.authenticationFiles

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val loading = MutableLiveData(false)

    fun logIn(
        email: String,
        password: String,
        navigate: () -> Unit,
        passwordAlert: () -> Unit,
        emailAlert: () -> Unit
    ) = viewModelScope.launch {
        if (email.isNotEmpty()) {
            if (password.isNotEmpty()) {
                try {
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                navigate()
                                Log.d("Logueo", "Logueo satisfactorio")
                            } else {
                                Toast.makeText(null, "Error de ingreso", Toast.LENGTH_SHORT).show()
                                Log.d("Logueo", "Error de logueo: ${task.result}")
                            }
                        }
                } catch (ex: Exception) {
                    Log.d("Logueo", "Error de logueo: ${ex.message}")
                }
            } else {
                passwordAlert()
            }
        } else {
            emailAlert()
        }
    }

    fun createUser(
        email: String,
        password: String,
        repeatedPassword: String,
        navigate: () -> Unit,
        passwordAlert: () -> Unit,
        emailAlert: () -> Unit,
        repeatedPasswordAlert: () -> Unit
    ) {
        if (email.isNotEmpty()) {
            if (password.isNotEmpty()) {
                if (password == repeatedPassword) {
                    if (loading.value == false) {
                        loading.value = true
                        auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    navigate()
                                } else {
                                    Toast.makeText(null, "Error de ingreso", Toast.LENGTH_SHORT)
                                        .show()
                                    Log.d("Logueo", "Error de creacion: ${task.result}")
                                }
                                loading.value = false
                            }
                    }
                } else {
                    repeatedPasswordAlert()
                }
            } else {
                passwordAlert()
            }
        } else {
            emailAlert()
        }
    }
}