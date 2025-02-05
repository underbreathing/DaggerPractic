package com.sheverdyaevartem.daggerpractic.di

import com.sheverdyaevartem.core.di.NetworkModule
import com.sheverdyaevartem.core.qualifiers.SecondServer
import com.sheverdyaevartem.home.di.HomeDeps
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent : HomeDeps {  // AppComponent реализует HomeDeps
    override fun firstRetrofit(): Retrofit

    @SecondServer
    override fun secondRetrofit(): Retrofit
}