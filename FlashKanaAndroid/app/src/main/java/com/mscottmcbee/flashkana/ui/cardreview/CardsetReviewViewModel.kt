package com.mscottmcbee.flashkana.ui.cardreview

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.mscottmcbee.flashkana.model.Repository
import com.mscottmcbee.flashkana.model.dataobjects.CardSet

open class CardsetReviewViewModel(cardSetId: String, repository: Repository) : ViewModel() {

    private var cardSet: CardSet = repository.getCardSetByID(cardSetId) ?: CardSet()
    var glyph = ObservableField<String>("")
    var answer = ObservableField<String>("")

    init {
        showNewCard()
    }

    fun onClick(view: View) {
        showNewCard()
    }

    fun getCardSetTitle(): String {
        return cardSet.title
    }

    private fun showNewCard() {
        var card = cardSet.getRandomCard()
        glyph.set(card?.question)
        answer.set(card?.answers?.first())
    }

}