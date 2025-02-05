package com.sheverdyaevartem.home.domain.impl

import com.sheverdyaevartem.home.domain.api.HomeInteractor
import com.sheverdyaevartem.home.domain.api.HomeRepository
import javax.inject.Inject

class HomeInteractorImpl @Inject constructor (private val homeRepository: HomeRepository): HomeInteractor {
    override fun getGeneralInfo(): String {
        return homeRepository.generalInfo()
    }

    override fun getUsersInfo(userId: String): List<String> {
        return homeRepository.usersInfo(userId)
    }
}