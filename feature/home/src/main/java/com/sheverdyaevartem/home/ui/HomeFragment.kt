package com.sheverdyaevartem.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.sheverdyaevartem.core.di.AppProvider
import com.sheverdyaevartem.core.ui.BaseInjectFragment
import com.sheverdyaevartem.home.databinding.FragmentHomeBinding
import com.sheverdyaevartem.home.di.FeatureHomeComponent
import javax.inject.Inject
import javax.inject.Provider

class HomeFragment : BaseInjectFragment() {

    companion object {

        private const val USER_ID_KEY = "user id key"

        fun createArgs(userId: String): Bundle {
            return bundleOf(USER_ID_KEY to userId)
        }
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels {
        homeViewModelFactory.get().create(requireArguments().getString(USER_ID_KEY, ""))
    }

    @Inject
    internal lateinit var homeViewModelFactory: Provider<HomeViewModel.HomeViewModelFactory.Factory>

    override fun inject(appProvider: AppProvider) {
        FeatureHomeComponent.init(appProvider).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.fetchData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}