package com.mscottmcbee.flashkana.model

class GenericModel : IFlashCardModel {

    var title: String = "title"
    var description: String = "description"
    var flashCards = mutableListOf<KanaObject>()

    constructor(modelTitle: String, modelDescription: String) {
        title = modelTitle
        description = modelDescription
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

    override fun getSetSubtitle(): String {
        return "hji"
    }

    override fun addCards(cards: List<KanaObject>) {
        flashCards.addAll(cards)
    }

    override fun removeCards() {
        flashCards.removeAll({ true })
    }
}