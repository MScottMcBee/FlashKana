package com.mscottmcbee.flashkana.ui.cardquiz

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.mscottmcbee.flashkana.model.IFlashCardModel
import com.mscottmcbee.flashkana.model.KanaObject
import com.mscottmcbee.flashkana.model.ModelProvider

class CardQuizViewModel(val id: Int) : ViewModel() {

    private var flashCardSet: IFlashCardModel = ModelProvider.instance.getModelByID(id)
    var glyph = ObservableField<String>("")
    private var correctIndex: Int = -1
    var possibleAnswers: ObservableArrayList<String> = ObservableArrayList()
    private var lastCard: KanaObject? = null

    init {
        showNewCard()
    }

    fun onClick(index: Int) {
        Log.d("AAAAAAAA", "asdadad, $index")
        if (index == correctIndex) {
            showNewCard()
        }
    }

    fun getCardSetTitle(): String {
        return flashCardSet.getSetName() ?: "UNKNOWN"
    }

    private fun showNewCard() {
        possibleAnswers.clear()
        var card = flashCardSet.getRandomCard()
        while (lastCard == card) {
            card = flashCardSet.getRandomCard()
        }
        lastCard = card

        glyph.set(card.glyph)
        possibleAnswers.add(card.answer)
        for (i in 0 until 3) {
            var newCard = flashCardSet.getRandomCard()
            while (possibleAnswers.contains(newCard.answer)) {
                newCard = flashCardSet.getRandomCard()
            }
            possibleAnswers.add(newCard.answer)
        }
        possibleAnswers.shuffle()
        correctIndex = possibleAnswers.indexOf(card.answer)
    }

}