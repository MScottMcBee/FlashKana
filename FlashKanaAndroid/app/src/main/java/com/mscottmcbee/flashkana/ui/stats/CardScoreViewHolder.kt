package com.mscottmcbee.flashkana.ui.stats

import android.support.v4.content.ContextCompat
import android.support.v4.graphics.ColorUtils
import android.support.v7.widget.RecyclerView
import android.view.View
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.model.IFlashCardModel
import kotlinx.android.synthetic.main.recycleitem_stats.view.*


class CardScoreViewHolder(var view: View, private var flashCardSet: IFlashCardModel) : RecyclerView.ViewHolder(view) {

    private val colorLow = ContextCompat.getColor(view.context, R.color.colorScoreLow)
    private val colorMed = ContextCompat.getColor(view.context, R.color.colorScoreMed)
    private val colorHigh = ContextCompat.getColor(view.context, R.color.colorScoreHigh)

    fun bind(index: Int) {
        view.recycleitem_stats_glyph.text = flashCardSet.getCard(index).glyph
        view.recycleitem_stats_answer.text = flashCardSet.getCard(index).answer
        view.recycleitem_stats_constraintlayout.setBackgroundColor(getScoreColor(flashCardSet.getCardScore(index)))
    }

    private fun getScoreColor(score: Int): Int {
        return when (score){
            in 0..49 -> ColorUtils.blendARGB(colorMed, colorHigh, ((score - 50) / 50f))
            in 51..100 -> ColorUtils.blendARGB(colorMed, colorLow, ((50 - score) / 50f))
            else -> colorMed
        }
    }

}