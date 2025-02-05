package com.sheverdyaevartem.home.di

import com.sheverdyaevartem.core.qualifiers.SecondServer
import com.sheverdyaevartem.core.scope.FeatureScope
import com.sheverdyaevartem.home.data.api.FirstService
import com.sheverdyaevartem.home.data.api.SecondService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ServiceModule {

    @FeatureScope
    @Provides
    fun provideFirstService(firstRetrofit: Retrofit): FirstService { // Без квалификатора
        return firstRetrofit.create(FirstService::class.java)
    }

    @FeatureScope
    @Provides
    fun provideSecondService(@SecondServer secondRetrofit: Retrofit): SecondService { // С квалификатором @SecondServer
        return secondRetrofit.create(SecondService::class.java)
    }
}