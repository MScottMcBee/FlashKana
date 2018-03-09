package com.mscottmcbee.flashkana.model

class ModelProvider() {

    companion object {
        lateinit var instance: ModelProvider
    }

    fun getModelByID(id:Int):IFlashCardModel{
        when(id){
            0 -> return TestingModel.instance
            1 -> return HiraganaModel.instance
            2 -> return KatakanaModel.instance
        }
        return TestingModel.instance
    }

    fun getNumModels(): Int{
        return 3
    }

    fun getTitle(id: Int): String{
        return getModelByID(id).getSetName()
    }

    fun getDescription(id: Int): String{
        return getModelByID(id).getSetDescription()
    }



}