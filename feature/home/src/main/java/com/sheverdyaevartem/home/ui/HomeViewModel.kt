package com.sheverdyaevartem.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sheverdyaevartem.core.utils.log
import com.sheverdyaevartem.home.domain.api.HomeInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel(private val homeInteractor: HomeInteractor) : ViewModel() {

    val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    fun fetchData() {
        viewModelScope.launch {
            homeInteractor.getGeneralInfo().log()
            homeInteractor.getUsersInfo("Sheverdyaev Artem").forEach { it.log() }
        }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(private val homeInteractor: HomeInteractor) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == HomeViewModel::class.java)
            return HomeViewModel(homeInteractor) as T
        }
    }
}