package com.greengoat3.android.myweatherapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.greengoat3.android.myweatherapp.databinding.ResultListItemBinding
import com.greengoat3.android.myweatherapp.logic.HourlyResponse
import com.greengoat3.android.myweatherapp.logic.OneCallApiResponse

private object DiffCallback : DiffUtil.ItemCallback<HourlyResponse>() {
    override fun areItemsTheSame(oldItem: HourlyResponse, newItem: HourlyResponse): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: HourlyResponse, newItem: HourlyResponse): Boolean {
        return oldItem.dt == newItem.dt
    }
}

class ResultListAdapter :
    ListAdapter<HourlyResponse, ResultListAdapter.MarsPropertyViewHolder>(DiffCallback) {

    class MarsPropertyViewHolder(private var binding: ResultListItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(marsProperty: HourlyResponse) {
            binding.property = marsProperty
            binding.icon = "http://openweathermap.org/img/wn/${marsProperty.weather[0].icon}.png"
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MarsPropertyViewHolder {
        return MarsPropertyViewHolder(ResultListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MarsPropertyViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.bind(marsProperty)
    }
}