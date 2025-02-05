package com.sheverdyaevartem.home.ui

import androidx.lifecycle.ViewModel
import com.sheverdyaevartem.home.di.DaggerFeatureHomeComponent
import com.sheverdyaevartem.home.di.HomeDepsStore

internal class HomeComponentViewModel : ViewModel() {
    val homeComponent = DaggerFeatureHomeComponent.builder().deps(HomeDepsStore.deps).build()
}