package com.akinozcitak.retrofitkotlin.adapter

import android.R.color
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akinozcitak.retrofitkotlin.databinding.RowLayoutBinding
import com.akinozcitak.retrofitkotlin.model.ColorBookModel


class RecyclerViewAdapter(
    private val colorList: ArrayList<ColorBookModel>, private val listener : Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>(){
    interface Listener {
        fun onItemClick(colorBookModel: ColorBookModel)
    }
    class RowHolder(val binding: RowLayoutBinding) :RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = RowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int {
        return colorList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {

        holder.itemView.setOnClickListener {
            listener.onItemClick(colorList.get(position))
        }
        holder.itemView.setBackgroundColor(Color.parseColor((colorList.get(position).hex)))
        holder.binding.colorName.text = colorList.get(position).name
        holder.binding.colorHex.text = colorList.get(position).hex
        holder.binding.colorRgb.text = colorList.get(position).rgb

    }
}