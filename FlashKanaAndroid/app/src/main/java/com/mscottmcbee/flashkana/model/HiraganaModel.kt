package com.mscottmcbee.flashkana.model


class HiraganaModel{

    companion object {

        var hiragana: Array<KanaObject> = arrayOf(
                KanaObject("あ", "a"),
                KanaObject("い", "i"),
                KanaObject("う", "u"),
                KanaObject("え", "e"),
                KanaObject("お", "o")
        )

        fun getRandomHiragana():KanaObject{
            return hiragana[(Math.random()* hiragana.size).toInt()]
        }

    }

}