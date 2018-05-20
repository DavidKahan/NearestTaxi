package com.kahan.david.nearesttaxi.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kahan.david.nearesttaxi.R
import com.kahan.david.nearesttaxi.model.Taxi

/**
 * Created by david on 20/05/2018.
 */
internal class TaxisAdapter(private var taxiList: List<Taxi>) : RecyclerView.Adapter<TaxisAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.taxi_item_card, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTaxi = taxiList[position]
        holder.stationIcon.setImageResource(currentTaxi.stationIconUrl)
        holder.stationNameTV.text = currentTaxi.stationName
        holder.etaTV.text = currentTaxi.etaStr
    }

    override fun getItemCount(): Int {
        return taxiList.size
    }

    fun setTaxiList(taxiList: List<Taxi>) {
        this.taxiList = taxiList
    }

    internal inner class MyViewHolder(taxiCard: View) : RecyclerView.ViewHolder(taxiCard) {
        var stationNameTV: TextView
        var etaTV: TextView
        var stationIcon: ImageView

        init {
            taxiCard.isClickable = false
            stationIcon = taxiCard.findViewById(R.id.station_icon)
            stationNameTV = taxiCard.findViewById(R.id.station_name_tv)
            etaTV = taxiCard.findViewById(R.id.eta_tv)
        }
    }
}