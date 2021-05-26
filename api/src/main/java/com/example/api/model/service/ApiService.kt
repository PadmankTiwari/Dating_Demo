package com.example.api.model.service

import com.example.api.ApiConstants
import com.example.api.model.request.*
import com.example.api.model.response.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST(ApiConstants.POST_REQUEST_OTP)
    fun getOtp(@Body otpRequest: OtpRequest): Call<Status>

    @POST(ApiConstants.POST_VERIFY_OTP)
    fun getVerifyOtp(@Body verifyOtpRequest: VerifyOtpRequest): Call<Token>

    @GET(ApiConstants.GET_PROFILE_LIST)
    fun getProfile(): Call<ProfileListResponse>
}