package com.sheverdyaevartem.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sheverdyaevartem.core.utils.log
import com.sheverdyaevartem.home.domain.api.HomeInteractor
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class HomeViewModel(
    private val userId: String, private val homeInteractor: HomeInteractor
) : ViewModel() {

    companion object {
        const val USER_ID_KEY = "user_id"
    }

    val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    fun fetchData() {
        viewModelScope.launch {
            homeInteractor.getGeneralInfo().log()
            homeInteractor.getUsersInfo(userId).forEach { it.log() }
        }
    }

    @Suppress("UNCHECKED_CAST")
    class HomeViewModelFactory @AssistedInject constructor(
        @Assisted(USER_ID_KEY) private val userId: String,
        private val homeInteractor: HomeInteractor
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == HomeViewModel::class.java)
            return HomeViewModel(userId, homeInteractor) as T
        }

        @AssistedFactory
        interface Factory {
            fun create(@Assisted(USER_ID_KEY) userId: String): HomeViewModel.HomeViewModelFactory
        }
    }
}