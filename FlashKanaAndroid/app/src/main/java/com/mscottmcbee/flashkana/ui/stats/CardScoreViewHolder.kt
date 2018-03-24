package com.mscottmcbee.flashkana.ui.stats

import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.ColorUtils
import android.support.v7.widget.RecyclerView
import android.view.View
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.model.IFlashCardModel
import kotlinx.android.synthetic.main.recycleitem_stats.view.*


class CardScoreViewHolder(var view: View, var flashCardSet: IFlashCardModel) : RecyclerView.ViewHolder(view) {

    private var cardScoreRecyclerInterface: CardScoreRecyclerInterface? = null
    val colorLow by lazy { ContextCompat.getColor(view.context, R.color.colorScoreLow) }
    val colorMed by lazy { ContextCompat.getColor(view.context, R.color.colorScoreMed) }
    val colorHigh by lazy { ContextCompat.getColor(view.context, R.color.colorScoreHigh) }

    fun bind(index: Int, recyclerInterface: CardScoreRecyclerInterface?) {
        cardScoreRecyclerInterface = recyclerInterface
        view.recycleitem_stats_glyph.text = flashCardSet.getCard(index).glyph
        view.recycleitem_stats_answer.text = flashCardSet.getCard(index).answer
        view.recycleitem_stats_constraintlayout.setBackgroundColor(getScoreColor(flashCardSet.getCardScore(index)))
    }

    fun getScoreColor(score: Int): Int {
        return when{
            score > 50 -> ColorUtils.blendARGB(colorMed, colorHigh, ((score - 50) / 50f))
            score < 50 -> ColorUtils.blendARGB(colorMed, colorLow, ((50-score) / 50f))
            else -> colorMed
        }
    }

}