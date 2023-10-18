package com.example.prototiposlan.viewModels

import com.example.prototiposlan.screens.ImageRepository
import com.example.prototiposlan.screens.ImageRepositoryImplementation
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ImageModule {
    @Provides
    fun ProvideFirebaseStorage() = Firebase.storage

    @Provides
    fun ProvideFirestore() = Firebase.firestore

    @Provides
    fun ProvideImageRepo(
        storage: FirebaseStorage,
        db: FirebaseFirestore
    ): ImageRepository = ImageRepositoryImplementation(storage, db)
}