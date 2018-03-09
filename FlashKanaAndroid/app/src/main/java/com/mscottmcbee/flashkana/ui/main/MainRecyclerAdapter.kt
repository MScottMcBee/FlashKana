package com.mscottmcbee.flashkana.ui.main

import android.content.Intent

import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.CardSet.CardSetDataClass
import com.mscottmcbee.flashkana.ui.kanaview.KanaViewActivity
import kotlinx.android.synthetic.main.recycleitem_main.view.*



class MainRecyclerAdapter() : RecyclerView.Adapter<MainViewHolder>() {

    private var mainRecyclerInterface: MainRecyclerInterface? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycleitem_main, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        //holder.bind(sets[position])
        holder.bind(position,mainRecyclerInterface)
    }

    override fun getItemCount(): Int {
        //sets.size
        return 12
    }

    fun setMainRecyclerInterface(mainRecyclerInterface: MainRecyclerInterface) {
        this.mainRecyclerInterface = mainRecyclerInterface
    }


}