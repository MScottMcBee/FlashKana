package com.mscottmcbee.flashkana.model.dataobjects

class Card() {
    var question: String = ""
    var answers: ArrayList<String> = ArrayList()
    var imageURL: String = ""
    var id: String = ""
}

fun <T> ArrayList<T>.random(): T {
    return this[(Math.random() * this.size).toInt()]
}
