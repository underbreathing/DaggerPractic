package com.sheverdyaevartem.core.network.api

import com.sheverdyaevartem.core.network.dto.RegisterAnswer
import retrofit2.http.GET

interface RegistrationService {

    @GET("registration/service/...")
    fun register(): RegisterAnswer
}