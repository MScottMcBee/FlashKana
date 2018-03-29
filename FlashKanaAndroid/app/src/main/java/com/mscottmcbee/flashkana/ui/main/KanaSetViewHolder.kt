package com.mscottmcbee.flashkana.ui.main

import android.support.v7.widget.RecyclerView
import android.transition.TransitionManager
import android.view.View
import com.mscottmcbee.flashkana.R
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
        //view.recycleitem_main_popout_multiple.setOnClickListener { kanaSetRecyclerInterface?.goToFlashCardMultiple(index) }
        view.recycleitem_main_popout_details.setOnClickListener { kanaSetRecyclerInterface?.goToFlashCardStats(index) }
        view.recycleitem_main_title2.text = ModelProvider.instance.getSubTitle(index)
        view.color_bar.setBackgroundColor(ModelProvider.instance.getSubColor(index))
        view.setOnClickListener {
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
        view.expand_thing.setImageResource(R.drawable.ic_expand_more_black_24px)
        TransitionManager.beginDelayedTransition(view.card)
    }

    private fun openPopOut() {
        closePopOuts()
        view.recycleitem_main_popout.visibility = View.VISIBLE
        view.expand_thing.setImageResource(R.drawable.ic_expand_less_black_24px)
        TransitionManager.beginDelayedTransition(view.card)
    }
}