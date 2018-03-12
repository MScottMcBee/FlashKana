package com.mscottmcbee.flashkana.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.model.ModelProvider


class MainRecyclerAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private var mainRecyclerInterface: MainRecyclerInterface? = null
    private var allViewHolders = mutableListOf<MainViewHolder>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycleitem_main, parent, false)
        allViewHolders.add(MainViewHolder(view))
        return allViewHolders.last()
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(position, mainRecyclerInterface, this)
    }

    override fun getItemCount(): Int {
        return ModelProvider.instance.getNumModels()
    }

    fun setMainRecyclerInterface(mainRecyclerInterface: MainRecyclerInterface) {
        this.mainRecyclerInterface = mainRecyclerInterface
    }

    fun closePopOuts() {
        for (holder in allViewHolders) {
            holder.closePopOut()
        }
    }


}