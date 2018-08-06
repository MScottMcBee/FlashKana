package com.mscottmcbee.flashkana.ui.main.recycler


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.databinding.RecycleitemMainBinding
import com.mscottmcbee.flashkana.model.ModelProvider


class KanaSetRecyclerAdapter : RecyclerView.Adapter<KanaSetViewHolder>() {

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

}