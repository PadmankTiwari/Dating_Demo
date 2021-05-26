package com.example.api.model.request

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class VerifyOtpRequest(
    @SerializedName("number")
    val number: String,
    @SerializedName("otp")
    val otp: String
)
