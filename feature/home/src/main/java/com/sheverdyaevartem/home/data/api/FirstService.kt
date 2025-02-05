package com.sheverdyaevartem.home.data.api

import retrofit2.http.GET

interface FirstService {

    @GET("authorization/service/...")
    fun fetchGeneralInfo(): String
}