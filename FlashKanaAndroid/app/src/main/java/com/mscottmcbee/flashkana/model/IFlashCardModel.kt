package com.mscottmcbee.flashkana.model

interface IFlashCardModel {
    fun getRandomCard(): KanaObject
    fun getSetName(): String
    fun getSetSubtitle(): String
    fun getSetDescription(): String
    fun addCards(cards: List<KanaObject>)
    fun removeCards()
}