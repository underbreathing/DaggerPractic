package com.sheverdyaevartem.home.di

import kotlin.properties.Delegates

object HomeDepsStore : HomeDepsProvider {
    override var deps: HomeDeps by Delegates.notNull()
}
