package com.koc.countries_paging_network_cache.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.koc.countries_paging_network_cache.R
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val logTag = this::class.java.simpleName

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inject ViewModel Repo
        val viewModelFactory: MainViewModelFactory by inject()

        //Get ViewModel
        viewModel = ViewModelProviders
                .of(this,
                        viewModelFactory)
                .get(MainActivityViewModel::class.java)

        viewModel.data.observe(this, Observer {
            it?.let {
                    Log.d(logTag, "Data change")
            }
        })

        viewModel.error.observe(this, Observer {
            it?.let {
                Log.d(logTag, "Error = $it")
            }
        })

        viewModel.loading.observe(this, Observer {
            it?.let {
                Log.d(logTag, "Loading = $it")
            }
        })

        viewModel.loadData()
    }
}
