/*package com.mscottmcbee.flashkana.room


class DefaultSetDatabase {
    fun getDefaultSetDatabase(): List<FlashBlockData>{
        val db = mutableListOf<FlashBlockData>()
        db.add(hiragana())
        db.add(katakana())
        db.add(testing())
        return db
    }
    private fun hiragana(): FlashBlockData{
        val setData = FlashBlockData()
        setData.setName = "Hiragana"
        setData.setDescription = "The first 50 hiragana gojuin"
        val pair = listOf(
                "あ" to "a",
                "い" to "i",
                "う" to "u",
                "え" to "e",
                "お" to "o",
                "か" to "ka",
                "き" to "ki",
                "く" to "ku",
                "け" to "ke",
                "こ" to "ko",
                "さ" to "sa",
                "し" to "shi",
                "す" to "su",
                "せ" to "se",
                "そ" to "so",
                "た" to "ta",
                "ち" to "chi",
                "つ" to "tsu",
                "て" to "te",
                "と" to "to",
                "な" to "na",
                "に" to "ni",
                "ぬ" to "nu",
                "ね" to "ne",
                "の" to "no",
                "は" to "ha",
                "ひ" to "hi",
                "ふ" to "fu",
                "へ" to "he",
                "ほ" to "ho",
                "ま" to "ma",
                "み" to "mi",
                "む" to "mu",
                "め" to "me",
                "も" to "mo",
                "や" to "ya",
                "ゆ" to "yu",
                "よ" to "yo",
                "ら" to "ra",
                "り" to "ri",
                "る" to "ru",
                "れ" to "re",
                "ろ" to "ro",
                "わ" to "wa",
                "を" to "wo",
                "ん" to "n"
        ).unzip()
        setData.answers = pair.first.toString().replace(" |]|\\[".toRegex(), "")
        setData.glyphs = pair.second.toString().replace(" |]|\\[".toRegex(), "")
        return setData
    }

    private fun katakana(): FlashBlockData{
        val setData = FlashBlockData()
        setData.setName = "Katakana"
        setData.setDescription = "The first 50 katakana gojuin"
        val pair = listOf(
                "ア" to "a",
                "イ" to "i",
                "ウ" to "u",
                "エ" to "e",
                "オ" to "o",
                "カ" to "ka",
                "キ" to "ki",
                "ク" to "ku",
                "ケ" to "ke",
                "コ" to "ko",
                "サ" to "sa",
                "シ" to "shi",
                "ス" to "su",
                "セ" to "se",
                "ソ" to "so",
                "タ" to "ta",
                "チ" to "chi",
                "ツ" to "tsu",
                "テ" to "te",
                "ト" to "to",
                "ナ" to "na",
                "ニ" to "ni",
                "ヌ" to "nu",
                "ネ" to "ne",
                "ノ" to "no",
                "ハ" to "ha",
                "ヒ" to "hi",
                "フ" to "fu",
                "ヘ" to "he",
                "ホ" to "ho",
                "マ" to "ma",
                "ミ" to "mi",
                "ム" to "mu",
                "メ" to "me",
                "モ" to "mo",
                "ヤ" to "ya",
                "ユ" to "yu",
                "ヨ" to "yo",
                "ラ" to "ra",
                "リ" to "ri",
                "ル" to "ru",
                "レ" to "re",
                "ロ" to "ro",
                "ワ" to "wa",
                "ヲ" to "wo",
                "ン" to "n"
        ).unzip()
        setData.answers = pair.first.toString().replace(" |]|\\[".toRegex(), "")
        setData.glyphs = pair.second.toString().replace(" |]|\\[".toRegex(), "")
        return setData
    }

    private fun testing(): FlashBlockData{
        val setData = FlashBlockData()
        setData.setName = ""
        setData.setDescription = ""
        val pair = listOf(
                "a" to "a",
                "b" to "b",
                "c" to "c",
                "d" to "d",
                "e" to "e",
                "f" to "f",
                "g" to "g",
                "h" to "h",
                "i" to "i"
        ).unzip()
        setData.answers = pair.first.toString().replace(" |]|\\[".toRegex(), "")
        setData.glyphs = pair.second.toString().replace(" |]|\\[".toRegex(), "")
        return setData
    }
}*/