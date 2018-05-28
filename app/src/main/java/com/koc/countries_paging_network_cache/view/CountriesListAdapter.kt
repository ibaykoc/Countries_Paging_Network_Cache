package com.koc.countries_paging_network_cache.view

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.koc.countries_paging_network_cache.R
import com.koc.countries_paging_network_cache.model.CountryValid

class CountriesListAdapter : PagedListAdapter<CountryValid, CountriesListAdapter.CountriesViewHolder>(
        object : DiffUtil.ItemCallback<CountryValid>() {
            override fun areItemsTheSame(oldItem: CountryValid, newItem: CountryValid): Boolean =
                    oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: CountryValid, newItem: CountryValid): Boolean =
                    oldItem == newItem
        }
) {

    val logTag = this::class.java.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.countries_list_item, null)
        return CountriesViewHolder(v)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        Log.d(logTag, "Bind")
        val countryItem = getItem(position)
        holder.text.text = countryItem?.name
    }

    class CountriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text = view.findViewById<TextView>(R.id.text)
    }

}