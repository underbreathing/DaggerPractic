package com.sheverdyaevartem.home.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.sheverdyaevartem.home.databinding.FragmentHomeBinding
import dagger.Lazy
import javax.inject.Inject

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels {
        homeViewModelFactory.get()
    }

    @Inject
    internal lateinit var homeViewModelFactory: Lazy<HomeViewModel.Factory>

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<HomeComponentViewModel>()
            .homeComponent.inject(this)

        super.onAttach(context)
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