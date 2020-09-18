package com.molette.app.joursferies.presentation.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.molette.app.joursferies.R
import com.molette.app.joursferies.databinding.HolidayCellBinding
import com.molette.app.joursferies.domain.models.Holiday
import java.util.*

class HolidaysAdapter: RecyclerView.Adapter<HolidayViewHolder>() {

    var holidays: List<Holiday> = mutableListOf()
        set(value) {
            field = value
            this.notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolidayViewHolder {

        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<HolidayCellBinding>(inflater, R.layout.holiday_cell, parent, false)
        return HolidayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HolidayViewHolder, position: Int) {
        val item = holidays.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return holidays.size
    }
}

class HolidayViewHolder(val binding: HolidayCellBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(holiday: Holiday){
        binding.holiday = holiday
    }
}