package com.mscottmcbee.flashkana.ui.kanaview

import android.view.View
import androidx.databinding.ObservableField
import com.mscottmcbee.flashkana.model.IFlashCardModel

class KanaViewViewModel(private val flashCardSet: IFlashCardModel){

    var glyph = ObservableField<String>("")
    var answer = ObservableField<String>("")

    init {
        showNewCard()
    }

    fun onClick(view: View){
        showNewCard()
    }

    private fun showNewCard(){
        var card = flashCardSet.getRandomCard()
        glyph.set(card.glyph)
        answer.set(card.answer)
    }

}