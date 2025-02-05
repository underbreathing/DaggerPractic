package com.sheverdyaevartem.home.di

interface HomeDepsProvider {
    val deps: HomeDeps

    companion object: HomeDepsProvider by HomeDepsStore
}