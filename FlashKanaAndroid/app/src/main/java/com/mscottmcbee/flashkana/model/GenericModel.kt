package com.mscottmcbee.flashkana.model

import com.mscottmcbee.flashkana.model.room.DatabaseWrapper

class GenericModel : IFlashCardModel {

    var title: String = "title"
    var description: String = "description"
    var uid = 0
    var flashCards = mutableListOf<KanaObject>()
    var cardScores = mutableListOf<Int>()
    var overallScore = 0
    var cardsViewed = 0
    var cardsQuizzed = 0

    constructor(modelTitle: String, modelDescription: String, modelUid: Int) {
        title = modelTitle
        description = modelDescription
        uid = modelUid
    }

    override fun getRandomCard(): KanaObject {
        return flashCards[(Math.random() * flashCards.size).toInt()]
    }

    override fun getSetName(): String {
        return title
    }

    override fun getSetDescription(): String {
        return description
    }

    override fun addCards(cards: List<KanaObject>) {
        flashCards.addAll(cards)
    }

    override fun removeCards() {
        flashCards.removeAll({ true })
    }

    override fun populateStats() {
        cardScores.removeAll({ true })
        cardScores.addAll(DatabaseWrapper.instance.getFlashBlockScores(uid))
        overallScore = cardScores.average().toInt()
        cardsViewed = DatabaseWrapper.instance.getFlashBlockStatViewed(uid)
        cardsQuizzed = DatabaseWrapper.instance.getFlashBlockStatQuizzed(uid)
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

    override fun getUID(): Int {
        return uid
    }

    override fun updateFlashBlockCardScore(glyph: String, score: Int) {
        DatabaseWrapper.instance.updateFlashBlockCardScore(uid, glyph, score)
    }
}