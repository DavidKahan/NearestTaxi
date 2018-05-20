package com.kahan.david.nearesttaxi.model

import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by david on 20/05/2018.
 */

class Taxi(var stationIconUrl: Int, var stationName: String?) {

    var etaInMin: Int = (Random().nextInt(120) + 1)

    val etaStr: String
        get() {
            val hours = TimeUnit.MINUTES.toHours(etaInMin.toLong())
            val remainMinute = etaInMin - TimeUnit.HOURS.toMinutes(hours)
            val locale = Locale.getDefault()

            if (hours <= 0) {
                return String.format(locale, "%2d", remainMinute) + "m"
            }

            return if (remainMinute <= 0) {
                String.format(locale, "%2d", hours) + "h "
            } else {
                String.format(locale, "%2d", hours) + "h "+ String.format(locale, "%2d", remainMinute) + "m"
            }

        }


}