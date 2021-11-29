package com.athul.weather.data

import com.athul.weather.api.WeatherService

class WeatherRepository: WeatherService {
    var weatherService:WeatherService = WeatherService.create()

    override suspend fun getCurrentWeather(
        query: String,
        clientId: String
    ): CurrentWeatherResponse {
        return weatherService.getCurrentWeather(query)
    }
}