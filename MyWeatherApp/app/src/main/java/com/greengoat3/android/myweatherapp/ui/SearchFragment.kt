package com.greengoat3.android.myweatherapp.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.greengoat3.android.myweatherapp.R
import com.greengoat3.android.myweatherapp.databinding.SearchFragmentBinding
import com.greengoat3.android.myweatherapp.logic.City

class SearchFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private lateinit var viewModel: SearchViewModel
    private lateinit var binding: SearchFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.resultRv.adapter = ResultListAdapter()

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, City.getCityList())
        binding.citySpinner.adapter = adapter
        binding.citySpinner.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedCityName = City.getCityList()[position]
        val selectedCity = City.toCity(selectedCityName)
        if (selectedCity != null) {
            viewModel.setCityName(selectedCity)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        viewModel.setCityName(City.NODATA)
    }
}