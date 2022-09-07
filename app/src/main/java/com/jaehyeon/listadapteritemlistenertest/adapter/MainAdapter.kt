package com.jaehyeon.listadapteritemlistenertest.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jaehyeon.listadapteritemlistenertest.databinding.ItemCustomDataBinding
import com.jaehyeon.listadapteritemlistenertest.model.CustomDataModel
import com.jaehyeon.listadapteritemlistenertest.util.CustomItemTouchCallBackInterface

/**
 * Created by Jaehyeon on 2022/09/07.
 */
class MainAdapter: ListAdapter<CustomDataModel, MainAdapter.MainViewHolder>(diffUtil), CustomItemTouchCallBackInterface {

    companion object {
        val diffUtil = object: DiffUtil.ItemCallback<CustomDataModel>() {
            override fun areItemsTheSame(
                oldItem: CustomDataModel,
                newItem: CustomDataModel
            ): Boolean  = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: CustomDataModel,
                newItem: CustomDataModel
            ): Boolean = oldItem.id == newItem.id

        }
    }

    inner class MainViewHolder(private val binding: ItemCustomDataBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(customDataModel: CustomDataModel) {
            binding.model = customDataModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(ItemCustomDataBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onItemMove(from_position: Int, to_position: Int): Boolean {
        return true
    }

    override fun onItemSwipe(position: Int) {
        val list = currentList.toMutableList()
        list.removeAt(position)
        submitList(list)
    }

}