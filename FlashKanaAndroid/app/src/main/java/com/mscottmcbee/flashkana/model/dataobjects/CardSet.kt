package com.mscottmcbee.flashkana.model.dataobjects

import android.graphics.Color

class CardSet() {
    var title: String = ""
    var subTitle: String = ""
    var description: String = ""
    var cards: ArrayList<Card> = ArrayList()
    var subscibers: Int = 0
    var author: String = ""
    var created: Int = 0
    var updated: Int = 0
    var dataVersion: Float = 0f
    var id: String = ""
    var color: String = ""

    var drawableColor: Int = Color.MAGENTA
        get() = Color.parseColor("#" + color)

    fun getRandomCard(): Card? {
        return cards.random()
    }

}