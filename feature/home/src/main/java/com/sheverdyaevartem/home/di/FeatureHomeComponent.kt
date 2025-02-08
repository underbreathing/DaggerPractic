package com.sheverdyaevartem.home.di

import com.sheverdyaevartem.core.di.AppProvider
import com.sheverdyaevartem.core.scope.FeatureScope
import com.sheverdyaevartem.home.ui.HomeFragment
import dagger.Component

@FeatureScope//вместо HomeDeps предоставлять AndroidDeps
@Component(
    dependencies = [AppProvider::class],
    modules = [ServiceModule::class, HomeBindModule::class]
)
interface FeatureHomeComponent {

    companion object{
        fun init(appProvider: AppProvider): FeatureHomeComponent{
            return DaggerFeatureHomeComponent.factory()
                .create(appProvider)
        }
    }

    fun inject(homeFragment: HomeFragment)

    @Component.Factory//использовать фэктори!!!
    interface Factory {
        fun create(appProvider: AppProvider): FeatureHomeComponent
    }
}