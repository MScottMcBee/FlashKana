package com.mscottmcbee.flashkana.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import com.mscottmcbee.flashkana.model.ModelProvider
import kotlinx.android.synthetic.main.recycleitem_main.view.*


class MainViewHolder(var view: View) : RecyclerView.ViewHolder(view){

    var mainRecyclerInterface: MainRecyclerInterface? = null

    fun bind(index :Int, recyclerInterface: MainRecyclerInterface?){
        mainRecyclerInterface = recyclerInterface
        closePopout()
        view.recycleitem_main_title.text = ModelProvider.instance.getTitle(index)//TODO do these need to be de-coupled?
        view.recycleitem_main_description.text = ModelProvider.instance.getDescription(index)
        view.recycleitem_main_popout_view.setOnClickListener { mainRecyclerInterface?.goToFlashCardView(index) }
        view.recycleitem_main_popout_quiz.setOnClickListener { mainRecyclerInterface?.goToFlashCardQuiz(index) }
        view.recycleitem_main_popout_multiple.setOnClickListener { mainRecyclerInterface?.goToFlashCardMultiple(index) }
        view.recycleitem_main_popout_details.setOnClickListener { mainRecyclerInterface?.bbb(index) }
        view.recycleitem_main_button.setOnClickListener {
            with(view.recycleitem_main_popout){
                when(visibility){
                    View.VISIBLE -> closePopout()
                    View.GONE -> openPopout()
                }
            }
        }
    }

    fun closePopout(){
        view.recycleitem_main_popout.visibility = View.GONE
    }

    private fun openPopout(){
        mainRecyclerInterface?.newPopoutOpened()
        view.recycleitem_main_popout.visibility = View.VISIBLE
    }
}