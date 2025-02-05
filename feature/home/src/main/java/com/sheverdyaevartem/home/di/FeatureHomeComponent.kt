package com.sheverdyaevartem.home.di

import com.sheverdyaevartem.core.scope.FeatureScope
import com.sheverdyaevartem.home.ui.HomeFragment
import dagger.Component

@FeatureScope
@Component(dependencies = [HomeDeps::class], modules = [ServiceModule::class, HomeBindModule::class])
interface FeatureHomeComponent {
    fun inject(homeFragment: HomeFragment)

    @Component.Builder
    interface Builder {
        fun deps(deps: HomeDeps): Builder
        fun build(): FeatureHomeComponent
    }
}