package com.sd.controller

import com.sd.services.ForecastService
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
    private lateinit var forecastService: ForecastService

    @RequestMapping("/getforecast/{location}", method =
    [RequestMethod.GET])
    @ResponseBody
    fun viewForecast(@PathVariable location: String): String {
        return forecastService.viewForeCast(location)
    }
}
