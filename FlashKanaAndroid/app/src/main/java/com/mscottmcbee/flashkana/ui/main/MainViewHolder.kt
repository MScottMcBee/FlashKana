package com.mscottmcbee.flashkana.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import com.mscottmcbee.flashkana.model.ModelProvider
import kotlinx.android.synthetic.main.recycleitem_main.view.*


class MainViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    private var mainRecyclerInterface: MainRecyclerInterface? = null
    private var mainRecyclerAdapter: MainRecyclerAdapter? = null

    fun bind(index: Int, recyclerInterface: MainRecyclerInterface?, RecyclerAdapter: MainRecyclerAdapter) {
        mainRecyclerInterface = recyclerInterface
        mainRecyclerAdapter = RecyclerAdapter
        closePopOut()
        view.recycleitem_main_title.text = ModelProvider.instance.getTitle(index)
        view.recycleitem_main_description.text = ModelProvider.instance.getDescription(index)
        view.recycleitem_main_popout_view.setOnClickListener { mainRecyclerInterface?.goToFlashCardView(index) }
        view.recycleitem_main_popout_quiz.setOnClickListener { mainRecyclerInterface?.goToFlashCardQuiz(index) }
        view.recycleitem_main_popout_multiple.setOnClickListener { mainRecyclerInterface?.goToFlashCardMultiple(index) }
        view.recycleitem_main_popout_details.setOnClickListener {}
        view.recycleitem_main_button.setOnClickListener {
            with(view.recycleitem_main_popout) {
                when (visibility) {
                    View.VISIBLE -> closePopOut()
                    View.GONE -> openPopOut()
                }
            }
        }
    }

    fun closePopOut() {
        view.recycleitem_main_popout.visibility = View.GONE
    }

    private fun openPopOut() {
        mainRecyclerAdapter?.closePopOuts()
        view.recycleitem_main_popout.visibility = View.VISIBLE
    }
}