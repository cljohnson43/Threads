package com.example.threads.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.threads.R
import com.example.threads.data.Waiter
import com.example.threads.databinding.ListItemWaiterBinding


class WaitersAdapter(val waitersList: List<Waiter>) :
    RecyclerView.Adapter<WaitersAdapter.WaitersViewModel>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaitersViewModel {
        val binding = DataBindingUtil.inflate<ListItemWaiterBinding>(
            LayoutInflater.from(parent.context),
            R.layout.list_item_waiter,
            parent,
            false
        )
        return WaitersViewModel(binding)
    }

    override fun getItemCount(): Int = waitersList.size

    override fun onBindViewHolder(holder: WaitersViewModel, position: Int) {
        val waiter = waitersList.get(position)
        (holder as WaitersViewModel).bind(waiter)

    }

    class WaitersViewModel(private val binding: ListItemWaiterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Waiter) {
            binding.apply {
                waiter = item
                executePendingBindings()
            }
        }
    }
}