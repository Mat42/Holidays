package com.molette.app.joursferies.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.molette.app.joursferies.R
import com.molette.app.joursferies.databinding.FragmentHomeBinding
import com.molette.app.joursferies.presentation.home.adapters.HolidaysAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private val homeViewModel by viewModel<HomeViewModel>()
    private  lateinit var adapter: HolidaysAdapter
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = HolidaysAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.holidaysRV.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.holidays.observe(viewLifecycleOwner, Observer{
            it.forEach{
                Log.d("loadHolidays", it.name)
            }
            adapter.holidays = it
        })
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {}
    }
}