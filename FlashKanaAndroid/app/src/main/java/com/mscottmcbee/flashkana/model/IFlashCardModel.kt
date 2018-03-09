package com.mscottmcbee.flashkana.model

interface IFlashCardModel {
    fun getRandomCard():KanaObject
    fun getSetName():String
    fun getSetDescription():String
}