package com.sheverdyaevartem.home.di

import com.sheverdyaevartem.core.qualifiers.SecondServer
import retrofit2.Retrofit


interface HomeDeps {

    fun firstRetrofit(): Retrofit

    @SecondServer
    fun secondRetrofit(): Retrofit
}
