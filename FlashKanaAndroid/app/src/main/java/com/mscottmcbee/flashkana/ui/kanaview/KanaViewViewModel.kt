package com.mscottmcbee.flashkana.ui.kanaview

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.mscottmcbee.flashkana.model.IFlashCardModel
import com.mscottmcbee.flashkana.model.ModelProvider

class KanaViewViewModel(val id:Int) : ViewModel(){

    private var flashCardSet:IFlashCardModel = ModelProvider.instance.getModelByID(id)
    var glyph = ObservableField<String>("")
    var answer = ObservableField<String>("")

    init{
        showNewCard()
    }

    fun onClick(view: View){
        showNewCard()
    }

    fun getCardSetTitle(): String{
        return flashCardSet.getSetName() ?: "UNKNOWN"
    }

    private fun showNewCard(){
        var card = flashCardSet.getRandomCard()
        glyph.set(card.glyph)
        answer.set(card.answer)
    }

}