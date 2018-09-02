package com.mscottmcbee.flashkana.ui.main

import androidx.lifecycle.ViewModel
import com.mscottmcbee.flashkana.model.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {

    fun getCardSets() = repository.getCardSets()

}