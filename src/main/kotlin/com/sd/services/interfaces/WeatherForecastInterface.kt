package com.sd.services.interfaces

import com.sd.pojo.WeatherForecastDataDTO

/**
 * @author Timofti Gabriel
 */

interface WeatherForecastInterface {
    fun getForecastData(locationId: Int): WeatherForecastDataDTO
}