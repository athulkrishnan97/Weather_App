package com.athul.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import com.athul.weather.data.WeatherRepository

class MainActivityViewModel: ViewModel() {

    suspend fun currentWeather(city:String):String{
        val weatherRepo = WeatherRepository()
        weatherRepo.getCurrentWeather(city).let {
            return ("${it.main?.temp}")
        }
        return "Could not get weather"
    }
}