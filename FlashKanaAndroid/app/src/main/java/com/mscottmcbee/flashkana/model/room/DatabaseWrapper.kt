package com.mscottmcbee.flashkana.model.room

import android.arch.persistence.room.Room
import android.content.Context
import android.graphics.Color
import com.mscottmcbee.flashkana.model.KanaObject


class DatabaseWrapper(context: Context) {

    private val masterdb = Room.databaseBuilder(context, MasterDatabase::class.java, "Master.db")
            .allowMainThreadQueries()
            .build()

    companion object {
        lateinit var instance: DatabaseWrapper
    }

    fun getFlashBlocks(): List<FlashBlockData> {
        return masterdb.flashBlockDAO().getAll()
    }

    fun getLinksByFlashBlockID(flashBlockID: Int?): List<LinkData> {
        return masterdb.linkDAO().getLinksByFlashBlockID(flashBlockID)
    }

    fun getFlashCardAsKanaObject(flashCardID: Int?): KanaObject {
        masterdb.flashCardDAO().getFlashCard(flashCardID).run {
            return KanaObject(flashCardAnswer, flashCardQuestion)
        }
    }

    fun getFlashBlockIDByTitle(flashBlockTitle: String): Int? {
        return masterdb.flashBlockDAO().getIDByTitle(flashBlockTitle)
    }

    fun insert(flashBlockName: String, flashBlockDescription: String, subTitle:String, color:Int) {
        masterdb.flashBlockDAO().insert(FlashBlockData(flashBlockName, flashBlockDescription,subTitle, color))
    }

    fun insert(flashCardAnswer: String, flashCardQuestion: String, flashCardType: String) {
        masterdb.flashCardDAO().insert(FlashCardData(flashCardAnswer, flashCardQuestion, flashCardType))
    }

    fun insert(flashBlockID: Int?, flashCardID: Int?) {
        masterdb.linkDAO().insert(LinkData(flashBlockID, flashCardID))
    }

    fun emptyDatabase() {
        masterdb.flashBlockDAO().deleteAll()
        masterdb.flashCardDAO().deleteAll()
        masterdb.linkDAO().deleteAll()
    }

    fun getFlashCardIDByQuestion(flashCardQuestion: String): Int? {
        return masterdb.flashCardDAO().getIDByQuestion(flashCardQuestion)
    }

    fun getFlashCardsOfFlashBlockAsKanaObjects(flashBlockID: Int?): List<KanaObject> {
        val links = getLinksByFlashBlockID(flashBlockID)
        val flashCardIDs = mutableListOf<Int?>()
        for (link in links) {
            flashCardIDs.add(link.linkDataFlashCardID)
        }
        val flashCards = masterdb.flashCardDAO().getFlashCards(flashCardIDs)
        val kanaObjects = mutableListOf<KanaObject>()
        for (flashCard in flashCards) {
            kanaObjects.add(KanaObject(flashCard.flashCardQuestion, flashCard.flashCardAnswer))
        }
        return kanaObjects
    }

    fun insertFlashCardsWithFlashBlock(flashBlockTitle: String, kanaObjects: List<KanaObject>, flashCardType: String) {
        val flashBlockID = getFlashBlockIDByTitle(flashBlockTitle)
        for (i in 0 until kanaObjects.size) {
            insert(kanaObjects[i].answer, kanaObjects[i].glyph, flashCardType)
            insert(flashBlockID, getFlashCardIDByQuestion(kanaObjects[i].glyph))
        }
    }

    fun getFlashBlockScores(flashBlockID: Int): List<Int> {
        return masterdb.linkDAO().getScores(flashBlockID)
    }

    fun getFlashBlockStatViewed(flashBlockID: Int): Int {
        return masterdb.flashBlockDAO().getStatViewed(flashBlockID)
    }

    fun getFlashBlockStatQuizzed(flashBlockID: Int): Int {
        return masterdb.flashBlockDAO().getStatQuizzed(flashBlockID)
    }

    fun incrementFlashBlockCardsViewed(flashBlockID: Int, cardsViewed: Int){
        masterdb.flashBlockDAO().updateStatViewed(flashBlockID, cardsViewed + getFlashBlockStatViewed(flashBlockID))
    }

    fun incrementFlashBlockCardsQuizzed(flashBlockID: Int, cardsQuizzed: Int){
        masterdb.flashBlockDAO().updateStatQuizzed(flashBlockID, cardsQuizzed + getFlashBlockStatQuizzed(flashBlockID))
    }

    fun updateFlashBlockCardScore(flashBlockID: Int, glyph: String, score: Int){
        val flashCardID  = masterdb.flashCardDAO().getIDByQuestion(glyph)
        val currentScore = masterdb.linkDAO().getCardScore(flashBlockID, flashCardID)
        masterdb.linkDAO().updateCardScore(flashBlockID, flashCardID, ((currentScore*.67)+(score*.33)).toInt())
    }


    fun defaultDatabase() {
        if (getFlashBlocks().isNotEmpty()) {
            return
        }

        insert("Hiragana", "The first 50 hiragana gojuin", "「ひらがな一」",  Color.parseColor("#3860c6"))
        insert("Katakana", "The first 50 katakana gojuin", "「カタカナ一」", Color.parseColor("#bc2626"))
        insert("Testing", "This is a test", "「クソ」", Color.BLACK)

        val testing: Array<KanaObject> = arrayOf(
                KanaObject("a", "a"),
                KanaObject("b", "b"),
                KanaObject("c", "c"),
                KanaObject("d", "d"),
                KanaObject("e", "e"),
                KanaObject("f", "f"),
                KanaObject("g", "g"),
                KanaObject("h", "h"),
                KanaObject("i", "i"),
                KanaObject("j", "j")
        )
        insertFlashCardsWithFlashBlock("Testing", testing.asList(), "testing")

        val hiragana: Array<KanaObject> = arrayOf(
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
        insertFlashCardsWithFlashBlock("Hiragana", hiragana.asList(), "hiragana")

        val katakana: Array<KanaObject> = arrayOf(
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
        insertFlashCardsWithFlashBlock("Katakana", katakana.asList(), "katakana")
    }
}