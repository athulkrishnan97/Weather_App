package com.athul.weather.api

import com.athul.weather.BuildConfig
import com.athul.weather.data.CurrentWeatherResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("data/2.5/weather?")
    suspend fun getCurrentWeather(
        @Query("q") query: String,
        @Query("appid") clientId: String = BuildConfig.OPENWEATHER_ACCESS_KEY
    ): CurrentWeatherResponse

    companion object {
        private const val BASE_URL = "https://api.openweathermap.org/"

        fun create(): WeatherService {

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherService::class.java)
        }
    }
}