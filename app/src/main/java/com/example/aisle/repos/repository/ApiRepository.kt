package com.example.aisle.repos.repository

import com.example.api.model.request.OtpRequest
import com.example.api.model.request.VerifyOtpRequest
import com.example.api.model.response.ProfileListResponse
import com.example.api.model.response.Status
import com.example.api.model.response.Token
import kotlinx.coroutines.flow.Flow


interface ApiRepository {
    suspend fun getOtp(otpRequest: OtpRequest): Flow<Status>

    suspend fun getProfileList(): Flow<ProfileListResponse>

    suspend fun verifyOtp(verifyOtpRequest: VerifyOtpRequest): Flow<Token>
}