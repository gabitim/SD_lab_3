package com.sd.services.interfaces

import com.sd.pojo.WeatherForecastData

/**
 * @author Timofti Gabriel
 */
interface LocationSearchInterface {
    fun getLocationId(locationName: String): Int
}

