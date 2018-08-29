package org.athaliapps.twilist.ui.main

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import org.athaliapps.twilist.BR

abstract class GenericListAdapter<T>(diffCallback: DiffUtil.ItemCallback<T>) :
        ListAdapter<T, GenericListAdapter.GenericViewHolder<T>>(diffCallback)
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return GenericViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenericViewHolder<T>, position: Int) = holder.bind(getItem(position))


    class GenericViewHolder<T>(private val dataBinding: ViewDataBinding) : RecyclerView.ViewHolder(dataBinding.root)
    {
        fun bind(item: T) {
            dataBinding.setVariable(BR.item, item)
            dataBinding.executePendingBindings()
        }
    }
}