package com.mscottmcbee.flashkana.ui.main

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.databinding.RecycleitemMainBinding
import com.mscottmcbee.flashkana.model.ModelProvider


class KanaSetRecyclerAdapter : RecyclerView.Adapter<KanaSetViewHolder>() {

    private var kanaSetRecyclerInterface: KanaSetRecyclerInterface? = null
  //  private var allViewHolders = mutableListOf<KanaSetViewHolder>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KanaSetViewHolder {
        var rimb: RecycleitemMainBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.recycleitem_main,parent,false)
        var holder = KanaSetViewHolder(rimb)

   //
        return holder
    }

    override fun onBindViewHolder(holder: KanaSetViewHolder, position: Int) {

        var gm = ModelProvider.instance.getModel(position)
        var model: KanaSetViewModel = KanaSetViewModel(gm)
        holder.binding.viewModel = model
        holder.binding.genericModel = gm
    }

    override fun getItemCount(): Int {
        return ModelProvider.instance.getNumModels()
    }

    fun setMainRecyclerInterface(kanaSetRecyclerInterface: KanaSetRecyclerInterface) {
        this.kanaSetRecyclerInterface = kanaSetRecyclerInterface
    }



}