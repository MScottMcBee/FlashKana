package com.mscottmcbee.flashkana.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import com.mscottmcbee.flashkana.model.ModelProvider
import kotlinx.android.synthetic.main.recycleitem_main.view.*


class KanaSetViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    private var kanaSetRecyclerInterface: KanaSetRecyclerInterface? = null
    private var closePopOuts: () -> Unit = {}

    fun bind(index: Int, recyclerInterface: KanaSetRecyclerInterface?, closePopOutsLambda: () -> Unit) {
        kanaSetRecyclerInterface = recyclerInterface
        closePopOuts = closePopOutsLambda
        closePopOut()
        view.recycleitem_main_title.text = ModelProvider.instance.getTitle(index)
        view.recycleitem_main_description.text = ModelProvider.instance.getDescription(index)
        view.recycleitem_main_popout_view.setOnClickListener { kanaSetRecyclerInterface?.goToFlashCardView(index) }
        view.recycleitem_main_popout_quiz.setOnClickListener { kanaSetRecyclerInterface?.goToFlashCardQuiz(index) }
        view.recycleitem_main_popout_multiple.setOnClickListener {}
        view.recycleitem_main_popout_details.setOnClickListener { kanaSetRecyclerInterface?.goToFlashCardStats(index) }
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
        closePopOuts()
        view.recycleitem_main_popout.visibility = View.VISIBLE
    }
}