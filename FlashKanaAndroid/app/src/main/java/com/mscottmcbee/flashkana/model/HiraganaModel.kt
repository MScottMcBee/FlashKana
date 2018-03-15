package com.mscottmcbee.flashkana.model

class HiraganaModel() : IFlashCardModel {

    companion object {

        lateinit var instance: HiraganaModel

        var hiragana: Array<KanaObject> = arrayOf(
                KanaObject("あ", "a"),
                KanaObject("い", "i"),
                KanaObject("う", "u"),
                KanaObject("え", "e"),
                KanaObject("お", "o"),
                KanaObject("か", "ka"),
                KanaObject("き", "ki"),
                KanaObject("く", "ku"),
                KanaObject("け", "ke"),
                KanaObject("こ", "ko"),
                KanaObject("さ", "sa"),
                KanaObject("し", "shi"),
                KanaObject("す", "su"),
                KanaObject("せ", "se"),
                KanaObject("そ", "so"),
                KanaObject("た", "ta"),
                KanaObject("ち", "chi"),
                KanaObject("つ", "tsu"),
                KanaObject("て", "te"),
                KanaObject("と", "to"),
                KanaObject("な", "na"),
                KanaObject("に", "ni"),
                KanaObject("ぬ", "nu"),
                KanaObject("ね", "ne"),
                KanaObject("の", "no"),
                KanaObject("は", "ha"),
                KanaObject("ひ", "hi"),
                KanaObject("ふ", "fu"),
                KanaObject("へ", "he"),
                KanaObject("ほ", "ho"),
                KanaObject("ま", "ma"),
                KanaObject("み", "mi"),
                KanaObject("む", "mu"),
                KanaObject("め", "me"),
                KanaObject("も", "mo"),
                KanaObject("や", "ya"),
                KanaObject("ゆ", "yu"),
                KanaObject("よ", "yo"),
                KanaObject("ら", "ra"),
                KanaObject("り", "ri"),
                KanaObject("る", "ru"),
                KanaObject("れ", "re"),
                KanaObject("ろ", "ro"),
                KanaObject("わ", "wa"),
                KanaObject("を", "wo"),
                KanaObject("ん", "n")
        )


    }

    override fun getRandomCard(): KanaObject {
        return hiragana[(Math.random() * hiragana.size).toInt()]
    }

    override fun getSetName(): String {
        return "Hiragana"
    }

    override fun getSetDescription(): String {
        /*return (listOf("A", "B", "C", "D").toString().replace(" |]|\\[".toRegex(), "")).split(",").toList().toString()
        return (listOf("A", "B", "C", "D").toString().replace(" |]|\\[".toRegex(), "")).split(",".toRegex()).toList().toString()
        return (listOf("A", "B", "C", "D").toString().replace(" ", "").replace("[", "").replace("]", "")).split(",".toRegex()).toString()
        return hiragana.joinToString()
        return mapOf("A" to "a", "B" to "b", "C" to "c", "D" to "d", "E" to "e", "F" to "f", "G" to "g").toString()*/
        return "The first 50 hiragana gojuin"
    }
}