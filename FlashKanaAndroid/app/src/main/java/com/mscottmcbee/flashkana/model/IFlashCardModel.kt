package com.mscottmcbee.flashkana.model

interface IFlashCardModel {
    fun getRandomCard(): KanaObject
    fun getSetName(): String
    fun getSetSubtitle(): String
    fun getSetDescription(): String
    fun getSetColor(): Int
    fun addCards(cards: List<KanaObject>)
    fun removeCards()
    fun populateStats()
    fun getCardScore(index: Int): Int
    fun getCard(index: Int): KanaObject
    fun getSize(): Int
    fun getStatsScore(): Int
    fun getStatsViewed(): Int
    fun getStatsQuizzed(): Int
    fun getFlashBlockUID(): Int
    fun updateFlashBlockCardScore(glyph: String, score: Int)
    fun updateCardsViewed(cardsViewed: Int)
    fun updateCardsQuizzed(cardsQuizzed: Int)
}