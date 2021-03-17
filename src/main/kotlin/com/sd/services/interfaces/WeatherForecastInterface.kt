package com.sd.services.interfaces

import com.sd.pojo.WeatherForecastData

/**
 * @author Timofti Gabriel
 */

interface WeatherForecastInterface {
    fun getForecastData(locationId: Int): WeatherForecastData
}