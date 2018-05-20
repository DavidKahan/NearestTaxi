package com.kahan.david.nearesttaxi.model

/**
 * Created by david on 20/05/2018.
 */
interface TaxisRepository {

    interface LoadTaxisCallback{
        fun onTaxisLoaded(loadedTaxis: List<Taxi>)
    }

    fun getTaxis(callback: LoadTaxisCallback)
}