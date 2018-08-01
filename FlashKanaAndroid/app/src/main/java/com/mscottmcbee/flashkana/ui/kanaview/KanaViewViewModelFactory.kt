package com.mscottmcbee.flashkana.ui.kanaview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class KanaViewViewModelFactory(
        private val id: Int
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = KanaViewViewModel(id) as T
}