package com.example.aisle.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.aisle.R
import com.example.aisle.databinding.ItemProfileBinding
import com.example.api.model.response.ProfileX
import javax.inject.Inject

class ProfileListAdapter @Inject constructor(private var profile: List<ProfileX>) :
    RecyclerView.Adapter<ProfileListAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_profile,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(position: Int) = profile[position]

    override fun getItemCount() = profile.size

    class Holder(private var itemBinding: ItemProfileBinding?) :
        RecyclerView.ViewHolder(itemBinding?.root as View) {
        fun bind(item: ProfileX) {
            itemBinding?.profile = item
        }
    }
}

