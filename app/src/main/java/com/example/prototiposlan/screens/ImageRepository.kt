package com.example.prototiposlan.screens

import android.net.Uri
import com.example.prototiposlan.viewModels.Response
import com.example.prototiposlan.viewModels.consts.IMAGES
import com.example.prototiposlan.viewModels.consts.URL
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

typealias UploadImage = Response<Uri>
typealias AddImageUrl = Response<Boolean>
typealias GetImage = Response<String>

interface ImageRepository {
    suspend fun UploadImage(imageUri: Uri): UploadImage
    suspend fun AddImageUrl(download: Uri): AddImageUrl
    suspend fun GetImage(): GetImage
}

class ImageRepositoryImplementation @Inject constructor(
    private val storage: FirebaseStorage,
    private val db: FirebaseFirestore
) : ImageRepository {
    private val auth: FirebaseAuth = Firebase.auth
    private val userId = auth.currentUser?.uid

    override suspend fun UploadImage(imageUri: Uri): UploadImage {
        return try {
            val downloadUrl = storage.reference.child(IMAGES).child("$userId.jpg")
                .putFile(imageUri).await()
                .storage.downloadUrl.await()
            Response.Succes(downloadUrl)
        } catch (e: Exception) {
            Response.Failure(e)
        }
    }

    override suspend fun AddImageUrl(download: Uri): AddImageUrl {
        return try {
            db.collection(IMAGES).document(userId.toString()).set(
                mapOf(
                    URL to download
                )
            ).await()
            Response.Succes(true)
        } catch (e: Exception) {
            Response.Failure(e)
        }
    }

    override suspend fun GetImage(): GetImage {
        return try {
            val imageUrl =
                db.collection(IMAGES).document(userId.toString()).get().await().getString(URL)
            Response.Succes(imageUrl)
        } catch (e:Exception) {Response.Failure(e)}
    }
}