package com.example.api.model.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Status(
    @SerializedName("status")
    val status: Boolean
)
