package com.sheverdyaevartem.core.di.network

import com.sheverdyaevartem.core.qualifiers.SecondServer
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule: NetworkProvider {


    /*
    МОжно билдеры здесь предоставлять

     */
    @Singleton
    @Provides
    override fun provideFirstServer(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fakeService11/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    @SecondServer
    override fun provideSecondServer(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fakeService22/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
