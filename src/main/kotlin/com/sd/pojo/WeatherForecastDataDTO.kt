package com.sd.pojo

/**
 * @author Timofti Gabriel
 */
data class WeatherForecastDataDTO (
    var location: String,
    var date: String,
    var weatherState: String,
    var weatherStateIconURL: String,
    var windDirection: String,
    var windSpeed: Int, // km/h
    var minTemp: Int, // grade celsius
    var maxTemp: Int,
    var currentTemp: Int,
    var humidity: Int // procent
) {
    fun toWeatherForecastData(): WeatherForecastData =
        WeatherForecastData(
            location = location,
            date = date,
            weatherState = weatherState,
            weatherStateIconURL = weatherStateIconURL,
            windDirection = windDirection,
            windSpeed = windSpeed,
            minTemp = minTemp,
            maxTemp = maxTemp,
            currentTemp = currentTemp,
            humidity = humidity
        )
}
