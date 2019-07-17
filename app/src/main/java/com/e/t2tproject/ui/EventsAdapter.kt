package com.e.t2tproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.e.t2tproject.R
import com.e.t2tproject.data.models.Event
import com.e.t2tproject.databinding.ItemEventBinding

class EventsAdapter : RecyclerView.Adapter<EventsAdapter.VH>() {

    var items = listOf<Event>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding: ItemEventBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_event, null, false)
        binding.viewModel = EventItemViewModel()
        return VH(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }

    class VH(private val binding: ItemEventBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event) {
            binding.viewModel?.start(event)
        }
    }
}