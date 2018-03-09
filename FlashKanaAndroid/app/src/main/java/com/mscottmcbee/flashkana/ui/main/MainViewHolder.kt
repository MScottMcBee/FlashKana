package com.mscottmcbee.flashkana.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.recycleitem_main.view.*


class MainViewHolder(var view: View) : RecyclerView.ViewHolder(view){

    fun bind(index :Int, mainRecyclerInterface: MainRecyclerInterface?){
        view.recycleitem_main_title.text = "$index"
        view.recycleitem_main_description.text = "$index"
        view.recycleitem_main_button.setOnClickListener { mainRecyclerInterface?.bbb(index) }
        view.recycleitem_main_popout_view.setOnClickListener { mainRecyclerInterface?.aaa(index) }
        view.recycleitem_main_popout_quiz.setOnClickListener { mainRecyclerInterface?.bbb(index) }
        view.recycleitem_main_popout_multiple.setOnClickListener { mainRecyclerInterface?.bbb(index) }
        view.recycleitem_main_popout_details.setOnClickListener { mainRecyclerInterface?.bbb(index) }
    }
}