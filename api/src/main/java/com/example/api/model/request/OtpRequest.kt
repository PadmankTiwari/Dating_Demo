package com.example.api.model.request

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class OtpRequest(
    @SerializedName("number")
    val number:String
)