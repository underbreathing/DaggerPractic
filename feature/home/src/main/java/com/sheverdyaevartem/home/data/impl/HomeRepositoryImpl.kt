package com.sheverdyaevartem.home.data.impl

import com.sheverdyaevartem.core.scope.FeatureScope
import com.sheverdyaevartem.home.data.api.FirstService
import com.sheverdyaevartem.home.data.api.SecondService
import com.sheverdyaevartem.home.domain.api.HomeRepository
import javax.inject.Inject

@FeatureScope
class HomeRepositoryImpl @Inject constructor (
    private val firstService: FirstService,
    private val secondService: SecondService
) : HomeRepository {
    override fun generalInfo(): String {
        return "general info"
    }

    override fun usersInfo(userId: String): List<String> {
        return listOf("User $userId is good", "others is bad")
    }
}
