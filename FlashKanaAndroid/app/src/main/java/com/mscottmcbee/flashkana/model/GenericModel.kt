package com.mscottmcbee.flashkana.model

import com.mscottmcbee.flashkana.model.room.DatabaseWrapper

class GenericModel(val title: String = "title", val description: String = "description", private val flashBlockUID: Int = 0) : IFlashCardModel {

    var flashCards = mutableListOf<KanaObject>()
    private var cardScores = mutableListOf<Int>()
    private var overallScore = 0
    private var cardsViewed = 0
    private var cardsQuizzed = 0
    private var databaseWrapper = DatabaseWrapper.instance

    override fun getRandomCard(): KanaObject {
        return flashCards[(Math.random() * flashCards.size).toInt()]
    }

    override fun getSetName(): String {
        return title
    }

    override fun getSetDescription(): String {
        return description
    }

    override fun getSetSubtitle(): String {
        return "hji"
    }

    override fun addCards(cards: List<KanaObject>) {
        flashCards.addAll(cards)
    }

    override fun removeCards() {
        flashCards.removeAll({ true })
    }

    override fun populateStats() {
        cardScores.removeAll({ true })
        cardScores.addAll(databaseWrapper.getFlashBlockScores(flashBlockUID))
        overallScore = cardScores.average().toInt()
        cardsViewed = databaseWrapper.getFlashBlockStatViewed(flashBlockUID)
        cardsQuizzed = databaseWrapper.getFlashBlockStatQuizzed(flashBlockUID)
    }

    override fun getCardScore(index: Int): Int {
        return cardScores[index]
    }

    override fun getCard(index: Int): KanaObject {
        return flashCards[index]
    }

    override fun getSize(): Int {
        return flashCards.size
    }

    override fun getStatsScore(): Int {
        return overallScore
    }

    override fun getStatsViewed(): Int {
        return cardsViewed
    }

    override fun getStatsQuizzed(): Int {
        return cardsQuizzed
    }

    override fun getFlashBlockUID(): Int {
        return flashBlockUID
    }

    override fun updateFlashBlockCardScore(glyph: String, score: Int) {
        databaseWrapper.updateFlashBlockCardScore(flashBlockUID, glyph, score)
    }

    override fun updateCardsViewed(cardsViewed: Int) {
        databaseWrapper.incrementFlashBlockCardsViewed(flashBlockUID, cardsViewed)
    }

    override fun updateCardsQuizzed(cardsQuizzed: Int) {
        databaseWrapper.incrementFlashBlockCardsQuizzed(flashBlockUID, cardsQuizzed)
    }
}