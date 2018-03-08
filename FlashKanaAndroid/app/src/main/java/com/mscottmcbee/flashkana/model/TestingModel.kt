package com.mscottmcbee.flashkana.model

class TestingModel() : IFlashCardModel {

    companion object {

        lateinit var instance: TestingModel

        var testing: Array<KanaObject> = arrayOf(
                KanaObject("a","a"),
                KanaObject("b","b"),
                KanaObject("c","c"),
                KanaObject("d","d"),
                KanaObject("e","e"),
                KanaObject("f","f"),
                KanaObject("g","g"),
                KanaObject("h","h"),
                KanaObject("i","i")
        )


    }

    override fun getRandomCard(): KanaObject {
        return testing[(Math.random()* testing.size).toInt()]
    }

    override fun getSetName(): String {
        return "Testing"
    }
}