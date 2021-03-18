package com.sd.services

import com.sd.pojo.WeatherForecastDataDTO
import com.sd.services.interfaces.WeatherForecastInterface
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.net.URL

/**
 * @author Timofti Gabriel
 */

@Service
class WeatherForecastService : WeatherForecastInterface {

    @Autowired
    private lateinit var timeService : TimeService

    override fun getForecastData(locationId: Int): WeatherForecastDataDTO {

// ID-ul locaţiei nu trebuie codificat, deoarece este numeric
        val forecastDataURL = URL("https://www.metaweather.com/api/location/$locationId/")

// preluare conţinut răspuns HTTP la o cerere GET către URL-ul de mai sus
        val rawResponse: String = forecastDataURL.readText()

// parsare obiect JSON primit
        val responseRootObject = JSONObject(rawResponse)
        val weatherDataObject = responseRootObject.getJSONArray("consolidated_weather").getJSONObject(0)

// construire şi returnare obiect POJO care încapsulează datele meteo
        return WeatherForecastDataDTO(
            location = responseRootObject.getString("title"),
            date = timeService.getCurrentTime(),
            weatherState = weatherDataObject.getString("weather_state_name"),
            weatherStateIconURL = "https://www.metaweather.com/static/img/weather/png/${weatherDataObject.getString("weather_state_abbr")}.png",
            windDirection = weatherDataObject.getString("wind_direction_compass"),
            windSpeed = weatherDataObject.getInt("wind_speed"),
            minTemp = weatherDataObject.getInt("min_temp"),
            maxTemp = weatherDataObject.getInt("max_temp"),
            currentTemp = weatherDataObject.getInt("the_temp"),
            humidity = weatherDataObject.getInt("humidity")
        )
    }
}