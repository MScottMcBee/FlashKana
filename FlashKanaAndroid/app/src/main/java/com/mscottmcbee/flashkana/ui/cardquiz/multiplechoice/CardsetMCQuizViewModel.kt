package com.mscottmcbee.flashkana.ui.cardquiz.multiplechoice

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.mscottmcbee.flashkana.model.Repository
import com.mscottmcbee.flashkana.model.dataobjects.Card
import com.mscottmcbee.flashkana.model.dataobjects.CardSet
import com.mscottmcbee.flashkana.model.dataobjects.random


class CardsetMCQuizViewModel(cardSetId: String, repository: Repository) : ViewModel() {

    private var cardSet: CardSet = repository.getCardSetByID(cardSetId) ?: CardSet()
    var glyph = ObservableField<String>("")
    private var correctIndex: Int = -1
    var possibleAnswers: ObservableArrayList<String> = ObservableArrayList()
    private var lastCard: Card? = null

    init {
        showNewCard()
    }

    fun onClick(index: Int) {
        if (index == correctIndex) {
            showNewCard()
        }
    }

    fun getCardSetTitle(): String {
        return cardSet.title
    }

    private fun showNewCard() {
        possibleAnswers.clear()
        var card: Card = cardSet.getRandomCard() ?: return
        while (lastCard == card) {
            card = cardSet.getRandomCard() ?: return
        }
        lastCard = card

        glyph.set(card.question)
        possibleAnswers.add(card.answers.random())
        for (i in 0 until 3) {
            var newCard = cardSet.getRandomCard()
            while (possibleAnswers.contains(newCard?.answers?.random())) {
                newCard = cardSet.getRandomCard()
            }
            possibleAnswers.add(newCard?.answers?.random())
        }
        possibleAnswers.shuffle()
        correctIndex = possibleAnswers.indexOf(card.answers.random())
    }

}