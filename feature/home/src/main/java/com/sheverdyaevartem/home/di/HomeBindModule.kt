package com.sheverdyaevartem.home.di

import com.sheverdyaevartem.home.data.impl.HomeRepositoryImpl
import com.sheverdyaevartem.home.domain.api.HomeInteractor
import com.sheverdyaevartem.home.domain.api.HomeRepository
import com.sheverdyaevartem.home.domain.impl.HomeInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface HomeBindModule {

    @Binds
    fun bindHomeInteractor_to_HomeInteractorImpl(homeInteractorImpl: HomeInteractorImpl): HomeInteractor

    @Binds
    fun bindHomeRepository_to_HomeRepositoryImpl(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository
}