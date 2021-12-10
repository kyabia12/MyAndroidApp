package com.greengoat3.android.myweatherapp.ui

import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greengoat3.android.myweatherapp.logic.City
import com.greengoat3.android.myweatherapp.logic.HourlyResponse
import com.greengoat3.android.myweatherapp.logic.WeatherApiRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel()  {
    // 経度・緯度のラジオボタンの設定
    private var _isLonlat: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLonlat: LiveData<Boolean> = _isLonlat

    // 経度・緯度の入力フォームの表示設定
    private var _lonlatVisibility: MutableLiveData<Int> = MutableLiveData(View.VISIBLE)
    val lonlatVisibility: LiveData<Int> = _lonlatVisibility

    // 都市のラジオボタンの設定
    private var _isCity: MutableLiveData<Boolean> = MutableLiveData(false)
    val isCity: LiveData<Boolean> = _isCity

    // 都市の入力フォームの表示設定
    private var _cityVisibility: MutableLiveData<Int> = MutableLiveData(View.GONE)
    val cityVisibility: LiveData<Int> = _cityVisibility

    //　天気APIの結果リスト
    private var _hourlyList: MutableLiveData<List<HourlyResponse>> = MutableLiveData()
    val hourlyList: LiveData<List<HourlyResponse>> = _hourlyList

    // 検索ボタンの設定
    private var _isSearchBtnClickable: MutableLiveData<Boolean> = MutableLiveData(true)
    val isSearchBtnClickable = _isSearchBtnClickable

    // ロジッククラスを格納
    val weatherApiRepository: WeatherApiRepository = WeatherApiRepository()

    // 経度の値
    val etlot: MutableLiveData<Double> = MutableLiveData<Double>(0.0)


    //　緯度の値
    val etlat: MutableLiveData<Double> = MutableLiveData<Double>(0.0)

    // 都市
    val selectedCity: MutableLiveData<City> = MutableLiveData<City>(City.NODATA)

    fun setCityName(city: City) {
        selectedCity.value = city
    }

    // 経度・緯度のラジオボタンのクリックイベントリスナー
    fun onLonlatBtnClicked() {
        // 経度・緯度の入力フォームを表示
        _isLonlat.value = true
        _lonlatVisibility.value = View.VISIBLE

        // 都市の入力フォームを非表示
        _isCity.value = false
        _cityVisibility.value = View.GONE
    }

    // 都市のラジオボタンのクリックイベントリスナー
    fun onCityBtnClicked() {
        // 経度・緯度の入力フォームを非表示
        _isLonlat.value = false
        _lonlatVisibility.value = View.GONE

        // 都市の入力フォームを表示
        _isCity.value = true
        _cityVisibility.value = View.VISIBLE
    }

    // 検索ボタンのクリックイベントリスナー
    fun onSearchBtnClicked() {
        var lon = 0.0
        var lat = 0.0
        if (isLonlat.value == true) {
            lon = etlat.value?: 0.0
            lat = etlot.value?: 0.0
        } else {
            lon = selectedCity.value?.lon?: 0.0
            lon = selectedCity.value?.lat?: 0.0
        }

        viewModelScope.launch {
            try {
                _isSearchBtnClickable.value = false
                val info = weatherApiRepository.getWeatherInfo(lon, lat)?.hourly
                _hourlyList.value = info
            } catch (e: Exception) {
                Log.e("SearchViewModel", e.toString())
            } finally {
                _isSearchBtnClickable.value = true
            }
        }
    }
}