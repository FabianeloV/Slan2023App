package com.example.prototiposlan.viewModels

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val showDialog = mutableStateOf(true)
    val showDialog1 = mutableStateOf(false)
    val showDialog3 = mutableStateOf(false)

    fun t2() {
        showDialog.value = !showDialog.value
    }

    fun t3() {
       showDialog1.value = !showDialog1.value
    }

    fun t1() {
        !showDialog3.value
    }
}