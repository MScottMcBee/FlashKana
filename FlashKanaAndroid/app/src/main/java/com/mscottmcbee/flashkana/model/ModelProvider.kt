package com.mscottmcbee.flashkana.model

import com.mscottmcbee.flashkana.model.room.*

class ModelProvider {

    private val databaseWrapper = DatabaseWrapper.instance
    private val flashBlocks = databaseWrapper.getFlashBlocks()
    private val models = mutableListOf<GenericModel>()

    constructor() {
        for (i in 0 until flashBlocks.size) {
            models.add(GenericModel(
                    flashBlocks[i].flashBlockName,
                    flashBlocks[i].flashBlockDescription))
        }
    }

    companion object {
        lateinit var instance: ModelProvider
    }

    fun getModelByID(id: Int): IFlashCardModel {
        models[id].addCards(
                databaseWrapper.getFlashCardsOfFlashBlockAsKanaObjects(flashBlocks[id].id))
        return models[id]
    }

    fun getNumModels(): Int {
        return models.size
    }

    fun getTitle(id: Int): String {
        return models[id].getSetName()
    }

    fun getDescription(id: Int): String {
        return models[id].getSetDescription()
    }
}