package com.mscottmcbee.flashkana.model

import androidx.lifecycle.MutableLiveData
import com.mscottmcbee.flashkana.model.dataobjects.CardSet

interface Repository {
    fun getCardSets(): MutableLiveData<HashMap<String, CardSet>>
    fun getCardSetByID(id: String): CardSet?
}