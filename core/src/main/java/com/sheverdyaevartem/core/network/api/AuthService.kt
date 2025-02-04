package com.sheverdyaevartem.core.network.api

import com.sheverdyaevartem.core.network.dto.AuthAnswer
import retrofit2.http.GET

interface AuthService {

    @GET("authorization/service/...")
    fun register(): AuthAnswer
}