package com.sd.services

import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Timofti Gabriel
 */

@Service
class TimeService {
    fun getCurrentTime(): String {
        val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
        return formatter.format(Date())
    }
}