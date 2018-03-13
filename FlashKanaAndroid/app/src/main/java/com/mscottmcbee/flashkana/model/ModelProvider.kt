package com.mscottmcbee.flashkana.model

class ModelProvider {

    companion object {
        lateinit var instance: ModelProvider
    }

    fun getModelByID(id: Int): IFlashCardModel {
        return when (id) {
            0 -> TestingModel.instance
            1 -> HiraganaModel.instance
            2 -> KatakanaModel.instance
            else -> TestingModel.instance
        }
    }

    fun getNumModels(): Int {
        return 3
    }

    fun getTitle(id: Int): String {
        return getModelByID(id).getSetName()
    }

    fun getDescription(id: Int): String {
        return getModelByID(id).getSetDescription()
    }


}