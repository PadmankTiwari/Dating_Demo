package com.example.aisle.ui.otp

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.aisle.repos.repository.ApiRepository
import com.example.aisle.ui.base.BaseViewModel
import com.example.aisle.utils.toLoadingState
import com.example.api.model.request.OtpRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect

class OtpViewModel @ViewModelInject constructor(private val apiRepository: ApiRepository) :
    BaseViewModel() {
    val mobileNumber = MutableLiveData<String>()

    fun getOtp() = liveData(Dispatchers.IO) {
        apiRepository.getOtp(
            OtpRequest(
                "+91${mobileNumber.value.toString()}"
            )
        ).toLoadingState().collect {
            emit(it)
        }
    }
}