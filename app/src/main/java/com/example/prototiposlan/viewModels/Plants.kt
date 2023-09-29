package com.example.prototiposlan.viewModels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Plants(
    @SerializedName("id") @Expose var id: Int? = null,
    @SerializedName("nombre") @Expose var name: String? = null,
    @SerializedName("nCientifico") @Expose var cientific: String? = null,
    @SerializedName("funcion") @Expose var funct: String? = null,
    @SerializedName("curioso") @Expose var data: String? = null,
    @SerializedName("codigo") @Expose var code: String? = null,
    @SerializedName("url") @Expose var url: String? = null
)
