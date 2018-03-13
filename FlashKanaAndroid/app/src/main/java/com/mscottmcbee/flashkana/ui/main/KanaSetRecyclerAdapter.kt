package com.mscottmcbee.flashkana.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.model.ModelProvider


class KanaSetRecyclerAdapter : RecyclerView.Adapter<KanaSetViewHolder>() {

    private var kanaSetRecyclerInterface: KanaSetRecyclerInterface? = null
    private var allViewHolders = mutableListOf<KanaSetViewHolder>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KanaSetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycleitem_main, parent, false)
        allViewHolders.add(KanaSetViewHolder(view))
        return allViewHolders.last()
    }

    override fun onBindViewHolder(holder: KanaSetViewHolder, position: Int) {
        holder.bind(position, kanaSetRecyclerInterface, {closePopOuts()})
    }

    override fun getItemCount(): Int {
        return ModelProvider.instance.getNumModels()
    }

    fun setMainRecyclerInterface(kanaSetRecyclerInterface: KanaSetRecyclerInterface) {
        this.kanaSetRecyclerInterface = kanaSetRecyclerInterface
    }

    private fun closePopOuts() {
        for (holder in allViewHolders) {
            holder.closePopOut()
        }
    }


}