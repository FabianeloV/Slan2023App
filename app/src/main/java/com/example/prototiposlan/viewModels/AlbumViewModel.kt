package com.example.prototiposlan.viewModels

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prototiposlan.screens.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(private val repo : ImageRepository): ViewModel(){
    var uploadImageState by mutableStateOf<Response<Uri>>(Response.Succes(null))
        private set
    private var addImageState by mutableStateOf<Response<Boolean>>(Response.Succes(null))

    fun uploadImageToStorage(imageUri: Uri) = viewModelScope.launch {
        uploadImageState = Response.Loading
        uploadImageState = repo.UploadImage(imageUri)
    }


    fun addImageUrl(downloadUri: Uri) = viewModelScope.launch {
        addImageState = Response.Loading
        addImageState = repo.AddImageUrl(downloadUri)
    }
}