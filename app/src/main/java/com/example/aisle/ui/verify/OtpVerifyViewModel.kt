package com.example.aisle.ui.verify

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.aisle.repos.repository.ApiRepository
import com.example.aisle.ui.base.BaseViewModel
import com.example.aisle.utils.toLoadingState
import com.example.api.model.request.OtpRequest
import com.example.api.model.request.VerifyOtpRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect

class OtpVerifyViewModel @ViewModelInject constructor(private val apiRepository: ApiRepository) : BaseViewModel() {

    val mobileNumber = MutableLiveData<String>()
    val otp = MutableLiveData<String>()

    fun getVerifyOtp() = liveData(Dispatchers.IO) {
        apiRepository.verifyOtp(
            VerifyOtpRequest(
                number = "+91${mobileNumber.value.toString()}",
                otp = otp.value.toString()
            )
        ).toLoadingState().collect {
            emit(it)
        }
    }
}