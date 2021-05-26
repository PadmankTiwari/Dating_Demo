package com.example.api.model.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Token(
    @SerializedName("token")
    val token: String
)
