package com.sheverdyaevartem.core.di

import com.sheverdyaevartem.core.qualifiers.SecondServer
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideFirstServer(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fakeService11/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    @SecondServer
    fun provideSecondServer(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fakeService22/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
