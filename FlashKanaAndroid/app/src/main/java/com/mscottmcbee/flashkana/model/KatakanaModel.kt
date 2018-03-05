package com.mscottmcbee.flashkana.model

class KatakanaModel() : IFlashCardModel{

    companion object {

        lateinit var instance: KatakanaModel

        var カタカナ: Array<KanaObject> = arrayOf(
                KanaObject("ア", "a"),
                KanaObject("イ", "i"),
                KanaObject("ウ", "u"),
                KanaObject("エ", "e"),
                KanaObject("オ", "o"),
                KanaObject("カ", "ka"),
                KanaObject("キ", "ki"),
                KanaObject("ク", "ku"),
                KanaObject("ケ", "ke"),
                KanaObject("コ", "ko"),
                KanaObject("サ", "sa"),
                KanaObject("シ", "shi"),
                KanaObject("ス", "su"),
                KanaObject("セ", "se"),
                KanaObject("ソ", "so"),
                KanaObject("タ", "ta"),
                KanaObject("チ", "chi"),
                KanaObject("ツ", "tsu"),
                KanaObject("テ", "te"),
                KanaObject("ト", "to"),
                KanaObject("ナ", "na"),
                KanaObject("ニ", "ni"),
                KanaObject("ヌ", "nu"),
                KanaObject("ネ", "ne"),
                KanaObject("ノ", "no"),
                KanaObject("ハ", "ha"),
                KanaObject("ヒ", "hi"),
                KanaObject("フ", "fu"),
                KanaObject("ヘ", "he"),
                KanaObject("ホ", "ho"),
                KanaObject("マ", "ma"),
                KanaObject("ミ", "mi"),
                KanaObject("ム", "mu"),
                KanaObject("メ", "me"),
                KanaObject("モ", "mo"),
                KanaObject("ヤ", "ya"),
                KanaObject("ユ", "yu"),
                KanaObject("ヨ", "yo"),
                KanaObject("ラ", "ra"),
                KanaObject("リ", "ri"),
                KanaObject("ル", "ru"),
                KanaObject("レ", "re"),
                KanaObject("ロ", "ro"),
                KanaObject("ワ", "wa"),
                KanaObject("ヲ", "wo"),
                KanaObject("ン", "n")
        )
    }

    override fun getRandomCard():KanaObject{
        return  カタカナ[(Math.random()* カタカナ.size).toInt()]
    }

    override fun getSetName(): String {
        return "Katakana"
    }
}