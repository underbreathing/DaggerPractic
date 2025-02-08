package com.sheverdyaevartem.core.di.network

import com.sheverdyaevartem.core.qualifiers.SecondServer
import retrofit2.Retrofit

interface NetworkProvider {
    fun provideFirstServer(): Retrofit

    @SecondServer
    fun provideSecondServer(): Retrofit
}
