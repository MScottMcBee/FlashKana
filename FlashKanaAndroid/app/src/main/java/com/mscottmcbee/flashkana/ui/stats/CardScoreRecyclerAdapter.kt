package com.mscottmcbee.flashkana.ui.stats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.model.dataobjects.CardSet


class CardScoreRecyclerAdapter(private val flashCardSet: CardSet) : RecyclerView.Adapter<CardScoreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardScoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycleitem_stats, parent, false)
        return CardScoreViewHolder(view, flashCardSet)
    }

    override fun onBindViewHolder(holder: CardScoreViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return flashCardSet.cards.size
    }
}