package com.sheverdyaevartem.home.domain.api

interface HomeRepository {

    fun generalInfo(): String

    fun usersInfo(userId: String): List<String>
}