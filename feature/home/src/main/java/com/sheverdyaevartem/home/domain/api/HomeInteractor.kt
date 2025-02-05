package com.sheverdyaevartem.home.domain.api

interface HomeInteractor {
    fun getGeneralInfo(): String

    fun getUsersInfo(userId: String): List<String>
}
