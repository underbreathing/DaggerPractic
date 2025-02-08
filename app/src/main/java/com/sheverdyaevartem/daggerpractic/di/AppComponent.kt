package com.sheverdyaevartem.daggerpractic.di

import com.sheverdyaevartem.core.di.AppProvider
import com.sheverdyaevartem.core.di.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent: AppProvider