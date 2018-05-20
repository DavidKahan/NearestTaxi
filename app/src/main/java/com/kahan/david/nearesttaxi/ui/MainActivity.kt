package com.kahan.david.nearesttaxi.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kahan.david.nearesttaxi.R
import com.kahan.david.nearesttaxi.model.Taxi

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var recyclerLayoutManager: RecyclerView.LayoutManager
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.initTaxis()

        recyclerLayoutManager = LinearLayoutManager(this)
        recyclerAdapter = TaxisAdapter(viewModel.getTaxis().value!!)

        recyclerView = findViewById<RecyclerView>(R.id.taxis_recycler_view).apply {

            setHasFixedSize(true)

            layoutManager = recyclerLayoutManager

            adapter = recyclerAdapter
        }

        viewModel.getTaxis().observe(this, Observer<List<Taxi>> { taxis ->
            // update UI
            if (taxis != null) {
                (recyclerAdapter as TaxisAdapter).setTaxiList(taxis)
                recyclerAdapter.notifyDataSetChanged()
            }
        })


    }


    override fun onResume() {
        handler = Handler()
        runnable = object : Runnable {
            override fun run() {
                viewModel.loadTaxis()
                handler.postDelayed(this, 5000)
            }
        }
        handler.postDelayed(runnable, 5000)
        super.onResume()
    }

    override fun onPause() {
        handler.removeCallbacks(runnable) //stop handler when activity is not visible
        super.onPause()
    }
}
