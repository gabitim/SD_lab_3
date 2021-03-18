package com.sd.controller

import com.sd.pojo.WeatherForecastData
import com.sd.pojo.WeatherForecastDataDTO
import com.sd.services.interfaces.LocationSearchInterface
import com.sd.services.interfaces.WeatherForecastInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 * @author Timofti Gabriel
 */

@Controller
class WeatherAppController {
    @Autowired
    private lateinit var locationSearchService: LocationSearchInterface
    @Autowired
    private lateinit var weatherForecastService: WeatherForecastInterface
    @RequestMapping("/getforecast/{location}", method =
    [RequestMethod.GET])
    @ResponseBody
    fun getForecast(@PathVariable location: String): String {
        // se incearca preluarea WOEID-ului locaţiei primite in URL
        val locationId = locationSearchService.getLocationId(location)

        // dacă locaţia nu a fost găsită, răspunsul va fi corespunzător
        if (locationId == -1) {
            return "Nu s-au putut gasi date meteo pentru cuvintele cheie \"$location\"!"
        }

        // pe baza ID-ului de locaţie, se interoghează al doilea serviciu care returnează datele meteo
        // Am adaugat un DTO
        val rawForecastDataDTO: WeatherForecastDataDTO = weatherForecastService.getForecastData(locationId)

        // funcţia toString() este suprascrisă pentru o afişare mai prietenoasă
        return rawForecastDataDTO.toWeatherForecastData().toString()
    }
}
