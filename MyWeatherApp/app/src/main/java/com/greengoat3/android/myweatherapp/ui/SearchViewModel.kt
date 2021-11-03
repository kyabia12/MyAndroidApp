package com.greengoat3.android.myweatherapp.ui

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greengoat3.android.myweatherapp.logic.HourlyResponse
import com.greengoat3.android.myweatherapp.logic.WeatherApiRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private var _isLonlat: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLonlat: LiveData<Boolean> = _isLonlat

    private var _lonlatVisibility: MutableLiveData<Int> = MutableLiveData(View.VISIBLE)
    val lonlatVisibility: LiveData<Int> = _lonlatVisibility

    private var _isCity: MutableLiveData<Boolean> = MutableLiveData(false)
    val isCity: LiveData<Boolean> = _isCity

    private var _cityVisibility: MutableLiveData<Int> = MutableLiveData(View.GONE)
    val cityVisibility: LiveData<Int> = _cityVisibility

    private var _hourlyList: MutableLiveData<List<HourlyResponse>> = MutableLiveData()
    val hourlyList: LiveData<List<HourlyResponse>> = _hourlyList

    val weatherApiRepository: WeatherApiRepository = WeatherApiRepository()

    fun onLonlatBtnClicked() {
        _isLonlat.value = true
        _lonlatVisibility.value = View.VISIBLE
        _isCity.value = false
        _cityVisibility.value = View.GONE
    }

    fun onCityBtnClicked() {
        _isCity.value = false
        _lonlatVisibility.value = View.GONE
        _isCity.value = true
        _cityVisibility.value = View.VISIBLE
    }

    fun onSearchBtnClicked() {
        viewModelScope.launch {
            val info = weatherApiRepository.getWeatherInfo()?.hourly
            _hourlyList.value = info
        }
    }
}