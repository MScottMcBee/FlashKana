package com.mscottmcbee.flashkana.ui.cardquiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class CardQuizViewModelFactory(
        private val id: Int
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = CardQuizViewModel(id) as T
}