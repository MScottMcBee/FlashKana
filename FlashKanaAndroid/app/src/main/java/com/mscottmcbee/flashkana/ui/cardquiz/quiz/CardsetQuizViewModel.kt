package com.mscottmcbee.flashkana.ui.cardquiz.quiz

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.mscottmcbee.flashkana.model.Repository
import com.mscottmcbee.flashkana.model.dataobjects.Card
import com.mscottmcbee.flashkana.model.dataobjects.CardSet

class CardsetQuizViewModel(cardSetId: String, repository: Repository) : ViewModel() {

    private var cardSet: CardSet = repository.getCardSetByID(cardSetId) ?: CardSet()
    var glyph = ObservableField<String>("")
    private var lastCard: Card? = null
    private lateinit var currentCard: Card
    var answerAttempt: ObservableField<String> = ObservableField("")

    var results: ObservableField<String> = ObservableField("")
    var spree: ObservableField<Int> = ObservableField(0)

    init {
        showNewCard()
    }

    fun onClick() {
        var x = currentCard.answers.filter { it.toUpperCase() == answerAttempt.get()?.toUpperCase() }
        if (x.count() > 0) {
            showNewCard()
            results.set("correct")
            spree.set(spree.get()?.plus(1)) // I hate it
        }else{
            results.set("incorrect")
            answerAttempt.set("")
            spree.set(0)
        }
    }

    fun getCardSetTitle(): String {
        return cardSet.title
    }

    fun onTextChanged( s: CharSequence, start: Int, before: Int, count:Int){
        answerAttempt.set(s.toString())
    }

    private fun showNewCard() {
        currentCard = cardSet.getRandomCard()
        while (lastCard == currentCard) {
            currentCard = cardSet.getRandomCard()
        }
        lastCard = currentCard

        glyph.set(currentCard.question)
        answerAttempt.set("")
    }

}