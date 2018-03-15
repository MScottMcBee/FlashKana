package com.mscottmcbee.flashkana.model

import android.arch.persistence.room.Room
import android.content.Context
import com.mscottmcbee.flashkana.room.*

class ModelProvider(var context: Context) {

    val flashBlockdb = Room.databaseBuilder(context, FlashBlockDatabase::class.java, "FlashBlock.db").allowMainThreadQueries().build()
    val flashBlocks: List<FlashBlockData> = flashBlockdb.flashBlockDAO().getAll()
    val flashCarddb = Room.databaseBuilder(context, FlashCardDatabase::class.java, "FlashCard.db").allowMainThreadQueries().build()
    val linkdb = Room.databaseBuilder(context, LinkDatabase::class.java, "Link.db").allowMainThreadQueries().build()

    companion object{
        lateinit var instance: ModelProvider
    }

    fun getModelByID(id: Int): IFlashCardModel {

        val linkData: List<LinkData> = linkdb.linkDAO().getLinksByFlashBlockID(flashBlocks[id].id)
        GenericModel.flashCards.removeAll{true}
        for(i in linkData){
            GenericModel.flashCards.add(KanaObject(flashCarddb.flashCardDAO().getFlashCard(i.linkDataFlashCardID).flashCardAnswer,
                    flashCarddb.flashCardDAO().getFlashCard(i.linkDataFlashCardID).flashCardQuestion))
        }

        GenericModel.description = flashBlocks[id].flashBlockDescription
        GenericModel.title = flashBlocks[id].flashBlockName
        GenericModel.flashCards.apply{
            removeAll({true})
            val links = linkdb.linkDAO().getLinksByFlashBlockID(flashBlocks[id].id)
            for(i in 0 until links.size){
                val flashCardData = flashCarddb.flashCardDAO().getFlashCard(links[i].linkDataFlashCardID)
                add(KanaObject(flashCardData.flashCardAnswer, flashCardData.flashCardQuestion))
            }
        }
        return GenericModel.instance
        /*return when (id) {
            0 -> TestingModel.instance
            1 -> HiraganaModel.instance
            2 -> KatakanaModel.instance
            else -> TestingModel.instance
        }*/
    }

    fun getNumModels(): Int {
        return flashBlocks.size
    }

    fun getTitle(id: Int): String {
        return flashBlocks[id].flashBlockName
        //return getModelByID(id).getSetName()
    }

    fun getDescription(id: Int): String {
        return flashBlocks[id].flashBlockDescription
        //return getModelByID(id).getSetDescription()
    }

    fun emptyDB(){
        flashBlockdb.flashBlockDAO().deleteAll()
        flashCarddb.flashCardDAO().deleteAll()
        linkdb.linkDAO().deleteAll()
    }

    fun default(){
        if(!flashBlocks.isEmpty()){
            return
        }
        flashBlockdb.flashBlockDAO().insert(FlashBlockData(null, "Hiragana", "The first 50 hiragana gojuin"))
        flashBlockdb.flashBlockDAO().insert(FlashBlockData(null, "Katakana", "The first 50 katakana gojuin"))
        flashBlockdb.flashBlockDAO().insert(FlashBlockData(null, "Testing", "This is a test"))

        val testing: Array<KanaObject> = arrayOf(
                KanaObject("a", "a"),
                KanaObject("b", "b"),
                KanaObject("c", "c"),
                KanaObject("d", "d"),
                KanaObject("e", "e"),
                KanaObject("f", "f"),
                KanaObject("g", "g"),
                KanaObject("h", "h"),
                KanaObject("i", "i")
        )
        var flashBlockID = flashBlockdb.flashBlockDAO().getIDByTitle("Testing")
        for(i in 0 until testing.size){
            flashCarddb.flashCardDAO().insert(FlashCardData(null, testing[i].answer, testing[i].glyph, "testing"))
            linkdb.linkDAO().insert(LinkData(null, flashBlockID, flashCarddb.flashCardDAO().getIDByAnswer(testing[i].answer)))
        }

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
        flashBlockID = flashBlockdb.flashBlockDAO().getIDByTitle("Hiragana")
        for(i in 0 until hiragana.size){
            flashCarddb.flashCardDAO().insert(FlashCardData(null, hiragana[i].answer, hiragana[i].glyph, "hiragana"))
            linkdb.linkDAO().insert(LinkData(null, flashBlockID, flashCarddb.flashCardDAO().getIDByQuestion(hiragana[i].glyph)))
        }

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
        flashBlockID = flashBlockdb.flashBlockDAO().getIDByTitle("Katakana")
        for(i in 0 until katakana.size){
            flashCarddb.flashCardDAO().insert(FlashCardData(null, katakana[i].answer, katakana[i].glyph, "katakana"))
            linkdb.linkDAO().insert(LinkData(null, flashBlockID, flashCarddb.flashCardDAO().getIDByQuestion(katakana[i].glyph)))
        }
    }
}