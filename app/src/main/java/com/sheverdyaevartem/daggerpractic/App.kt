package com.sheverdyaevartem.daggerpractic

import android.app.Application
import com.sheverdyaevartem.daggerpractic.di.AppComponent
import com.sheverdyaevartem.daggerpractic.di.DaggerAppComponent
import com.sheverdyaevartem.home.di.HomeDepsStore

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
        HomeDepsStore.deps = appComponent
    }

}