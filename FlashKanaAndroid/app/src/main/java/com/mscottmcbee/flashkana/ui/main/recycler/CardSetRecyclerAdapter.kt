package com.mscottmcbee.flashkana.ui.main.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.databinding.ViewholderCardsetBinding
import com.mscottmcbee.flashkana.model.dataobjects.CardSet

class CardSetRecyclerAdapter(var data: List<CardSet>) : RecyclerView.Adapter<CardSetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardSetViewHolder {
        var rimb: ViewholderCardsetBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.viewholder_cardset, parent, false)
        var holder = CardSetViewHolder(rimb)

        return holder
    }

    override fun onBindViewHolder(holder: CardSetViewHolder, position: Int) {

        var cardSet = data[position]
        var model: CardSetViewModel = CardSetViewModel(cardSet)
        holder.binding.viewModel = model
        holder.binding.cardSet = cardSet
    }

    override fun getItemCount(): Int {
        return data.size
    }

}