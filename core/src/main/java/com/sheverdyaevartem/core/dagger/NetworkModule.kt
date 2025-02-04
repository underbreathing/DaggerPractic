package com.sheverdyaevartem.core.dagger

import com.sheverdyaevartem.core.network.api.AuthService
import com.sheverdyaevartem.core.network.api.RegistrationService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface NetworkModule {

    //TODO converterFactory
    @Provides
    fun provideRegistrationService(): RegistrationService {
        return Retrofit.Builder()
            .baseUrl("https://fakeService1/")
            .build().create(RegistrationService::class.java)
    }

    fun provideAuthService(): AuthService {
        return Retrofit.Builder()
            .baseUrl("https://fakeService2/")
            .build().create(AuthService::class.java)
    }
}
