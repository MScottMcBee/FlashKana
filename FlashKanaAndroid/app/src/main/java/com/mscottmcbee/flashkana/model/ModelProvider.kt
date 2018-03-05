package com.mscottmcbee.flashkana.model

class ModelProvider() {

    companion object {
        lateinit var instance: ModelProvider
    }

    fun getModelByID(id:Int):IFlashCardModel?{
        when(id){
            1 -> return HiraganaModel.instance
            2 -> return KatakanaModel.instance
        }
        return null
    }



}