package com.mscottmcbee.flashkana.model

class GenericModel : IFlashCardModel {

    companion object {
        lateinit var instance: GenericModel
        lateinit var title: String
        lateinit var description: String
        var flashCards = mutableListOf<KanaObject>()
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
}