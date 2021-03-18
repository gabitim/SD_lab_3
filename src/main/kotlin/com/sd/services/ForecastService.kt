package com.sd.services

import com.sd.pojo.WeatherForecastDataDTO
import com.sd.services.interfaces.LocationSearchInterface
import com.sd.services.interfaces.WeatherForecastInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author Timofti Gabriel
 */

@Service
class ForecastService {
    @Autowired
    private lateinit var locationSearchService: LocationSearchInterface
    @Autowired
    private lateinit var weatherForecastService: WeatherForecastInterface

    fun viewForeCast(location: String): String {
        // se incearca preluarea WOEID-ului locaţiei primite in URL
        val locationId = locationSearchService.getLocationId(location)

        // dacă locaţia nu a fost găsită, răspunsul va fi corespunzător
        if (locationId == -1) {
            return "Nu s-au putut gasi date meteo pentru cuvintele cheie \"$location\"!"
        }

        val rawForecastDataDTO: WeatherForecastDataDTO = weatherForecastService.getForecastData(locationId)

        // funcţia toString() este suprascrisă pentru o afişare mai prietenoasă
        return rawForecastDataDTO.toWeatherForecastData().toString()
    }
}