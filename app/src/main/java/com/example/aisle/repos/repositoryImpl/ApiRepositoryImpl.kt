package com.example.aisle.repos.repositoryImpl

import com.example.aisle.data.session.SessionManager
import com.example.aisle.repos.repository.ApiRepository
import com.example.aisle.utils.bodyOrThrow
import com.example.api.model.request.OtpRequest
import com.example.api.model.request.VerifyOtpRequest
import com.example.api.model.service.ApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val sessionManager: SessionManager
) : ApiRepository {

    override suspend fun getOtp(otpRequest: OtpRequest) = flow {
        val response = apiService.getOtp(otpRequest = otpRequest)
            .execute()
            .bodyOrThrow()
        emit(response)
    }

    override suspend fun getProfileList() = flow {
        val response = apiService.getProfile()
            .execute()
            .bodyOrThrow()
        emit(response)
    }

    override suspend fun verifyOtp(verifyOtpRequest: VerifyOtpRequest) = flow {
        val response = apiService.getVerifyOtp(verifyOtpRequest = verifyOtpRequest)
            .execute()
            .bodyOrThrow()
        sessionManager.saveToken(response.token)
        emit(response)
    }
}