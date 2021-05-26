package com.example.aisle.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.liveData
import com.example.aisle.repos.repository.ApiRepository
import com.example.aisle.ui.base.BaseViewModel
import com.example.aisle.utils.toLoadingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect

class HomeViewModel @ViewModelInject constructor(private val apiRepository: ApiRepository) :
    BaseViewModel() {

    fun getProfileList() = liveData(Dispatchers.IO) {
        apiRepository.getProfileList().toLoadingState().collect {
            emit(it)
        }
    }
}