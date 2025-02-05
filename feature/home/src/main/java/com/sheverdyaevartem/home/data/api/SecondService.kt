package com.sheverdyaevartem.home.data.api

import retrofit2.http.GET

interface SecondService {

    @GET("registration/service/...")
    fun fetchUserInfo(): List<String>
}