package com.mscottmcbee.flashkana.ui.cardquiz.quizpicker

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.model.Repository
import com.mscottmcbee.flashkana.ui.cardquiz.quiz.CardsetQuizFragment


class QuizPickerViewModel(private val cardSetId: String, private val repository: Repository) : ViewModel() {

    fun onClick(view: View, index: Int) {
        var bundle: Bundle = Bundle().apply { putString(CardsetQuizFragment.Model_ID, cardSetId) }
        when (index) {
            0 -> Navigation.findNavController(view).navigate(R.id.picker_to_mc, bundle)
            1 -> Navigation.findNavController(view).navigate(R.id.picker_to_quiz, bundle)
        }
    }

    fun getCardSetTitle(): String {
        return repository.getCardSetByID(cardSetId)?.title ?: ""
    }
}