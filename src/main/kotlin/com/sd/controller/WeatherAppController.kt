package com.sd.controller

import com.sd.pojo.WeatherForecastDataDTO
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
    private lateinit var weatherForecastService: WeatherForecastInterface
    @RequestMapping("/getforecast/{location}", method =
    [RequestMethod.GET])
    @ResponseBody
    fun getForecast(@PathVariable location: String): String {

        // apelam un singur serviciu, iar din acel serviciu, apelam alte servicii de care mai avem nevoie
        // si asa mai departe --> chaining  ; ca un pipeline
        val rawForecastDataDTO: WeatherForecastDataDTO? = weatherForecastService.getForecastData(location)

        return rawForecastDataDTO?.toWeatherForecastData()?.toString()
            ?: "Nu s-au putut gasi date meteo pentru cuvintele cheie \"$location\"!"

    }
}
