package com.example.prototiposlan.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val loading = MutableLiveData(false)

    fun singInGoogle(credential: AuthCredential, navigate: () -> Unit, errorAlert: () -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithCredential(credential)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            navigate()
                            addUserField(auth.currentUser?.displayName.toString(), auth.currentUser?.photoUrl.toString())
                        }
                    }
                    .addOnFailureListener { errorAlert() }
            } catch (ex: Exception) {
                Log.d("Logueo google", "Error de logueo con google: ${ex.message}")
            }
        }

    fun logIn(
        email: String,
        password: String,
        navigate: () -> Unit,
        passwordAlert: () -> Unit,
        emailAlert: () -> Unit,
        errorAlert: () -> Unit
    ) = viewModelScope.launch {
        if (email.isNotEmpty()) {
            if (password.length >= 6) {
                try {
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                navigate()
                            }
                            if (!task.isSuccessful) {
                                errorAlert()
                            }
                            if (task.isCanceled) {
                                errorAlert()
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
        nickName: String,
        age: String,
        navigate: () -> Unit,
        passwordAlert: () -> Unit,
        emailAlert: () -> Unit,
        repeatedPasswordAlert: () -> Unit,
        errorAlert: () -> Unit
    ) {
        if (email.isNotEmpty()) {
            if (password.length >= 6) {
                if (password == repeatedPassword) {
                    if (loading.value == false) {
                        loading.value = true
                        auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    addUserField(nickName, age)
                                    navigate()
                                }
                                if (!task.isSuccessful) {
                                    errorAlert()
                                }
                                if (task.isCanceled) {
                                    errorAlert()
                                }
                            }
                        loading.value = false
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

    private fun addUserField(nickName: String,avatar:String) {
        val userId = auth.currentUser?.uid

        val userField = UserFields(
            id = userId.toString(),
            nickname = nickName,
            avatar = avatar,
            points = 0,
            age = ""
        ).userMap()

        FirebaseFirestore.getInstance().collection("users")
            .document(userId.toString())
            .set(userField)
            .addOnSuccessListener { Log.d("userField", "creado $it") }
            .addOnFailureListener { Log.d("userField", "error $it") }

    }
}