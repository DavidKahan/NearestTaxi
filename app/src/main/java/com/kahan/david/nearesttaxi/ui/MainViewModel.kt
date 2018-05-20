package com.kahan.david.nearesttaxi.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kahan.david.nearesttaxi.model.StubTaxisRepository
import com.kahan.david.nearesttaxi.model.Taxi
import com.kahan.david.nearesttaxi.model.TaxisRepository
import java.util.*

/**
 * Created by david on 20/05/2018.
 */
class MainViewModel : ViewModel() {

    private val taxis = MutableLiveData<List<Taxi>>()
    private lateinit var repository: TaxisRepository

    fun initTaxis (){
        repository = StubTaxisRepository
        loadTaxis()
    }

    fun getTaxis(): LiveData<List<Taxi>> {
        return taxis
    }

    fun loadTaxis() {
        repository.getTaxis( object : TaxisRepository.LoadTaxisCallback {
            override fun onTaxisLoaded(loadedTaxis: List<Taxi>) {
                Collections.sort(loadedTaxis) { t1, t2 -> Integer.compare(t1.etaInMin, t2.etaInMin) }
                taxis.value = loadedTaxis
            }
        })
    }
}