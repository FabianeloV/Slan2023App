package com.example.prototiposlan.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel:ViewModel() {
    var homeMarkerValue by mutableStateOf(0)
}