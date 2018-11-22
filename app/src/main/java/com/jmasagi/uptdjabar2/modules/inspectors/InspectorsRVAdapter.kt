package com.jmasagi.uptdjabar2.modules.inspectors

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jmasagi.uptdjabar2.R
import com.jmasagi.uptdjabar2.databinding.InspectorsItemBinding

class InspectorsRVAdapter(
    val data: ArrayList<InspectorsViewModel>
) : RecyclerView.Adapter<InspectorsRVAdapter.InspectorsViewHolder>() {

    private var layoutInflater: LayoutInflater? = null

    class InspectorsViewHolder(val binding: InspectorsItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: InspectorsViewHolder, position: Int) {
        holder.run {
            binding.model = data[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InspectorsViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        val binding =
            DataBindingUtil.inflate<InspectorsItemBinding>(layoutInflater!!, R.layout.inspectors_item, parent, false)
        return InspectorsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}