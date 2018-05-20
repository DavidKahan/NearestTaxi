package com.kahan.david.nearesttaxi.model

import com.kahan.david.nearesttaxi.R
import java.util.*

/**
 * Created by david on 20/05/2018.
 */
object StubTaxisRepository : TaxisRepository {

    private val taxis = Arrays.asList(
            Taxi(R.drawable.golden, "Habima"),
            Taxi(R.drawable.spurs, "Spurs"),
            Taxi(R.drawable.cavaliers, "Shekem"),
            Taxi(R.drawable.golden, "Habima"),
            Taxi(R.drawable.raptors, "Gordon"),
            Taxi(R.drawable.sixers, "Azrieli"),
            Taxi(R.drawable.rockets, "Hadera"),
            Taxi(R.drawable.knicks, "Apple"),
            Taxi(R.drawable.lakers, "Top10"),
            Taxi(R.drawable.blazers, "Tapuz"),
            Taxi(R.drawable.wizards, "Wizards"),
            Taxi(R.drawable.celtics, "Celtics"),
            Taxi(R.drawable.grizzlies, "Grizzlies"),
            Taxi(R.drawable.heat, "Heat"),
            Taxi(R.drawable.jazz, "Jazz"),
            Taxi(R.drawable.mavericks, "Mavericks"),
            Taxi(R.drawable.thunder, "Thunder"),
            Taxi(R.drawable.timberwolves, "Timberwolves")
            )


    override fun getTaxis(callback: TaxisRepository.LoadTaxisCallback) {
        for (taxi in taxis) {
            taxi.etaInMin = (Random().nextInt(120) + 1)
        }
        callback.onTaxisLoaded(taxis)
    }

}