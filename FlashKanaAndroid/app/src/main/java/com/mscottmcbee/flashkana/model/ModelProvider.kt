package com.mscottmcbee.flashkana.model

import android.content.Context
import com.mscottmcbee.flashkana.room.*

class ModelProvider {

    private val databaseWrapper = DatabaseWrapper.instance
    private val flashBlocks = databaseWrapper.getFlashBlocks()

    companion object {
        lateinit var instance: ModelProvider
    }

    fun getModelByID(id: Int): IFlashCardModel {
        GenericModel.flashCards.removeAll { true }
        GenericModel.flashCards.addAll(
                databaseWrapper.getFlashCardsOfFlashBlockAsKanaObjects(flashBlocks[id].id))

        GenericModel.description = flashBlocks[id].flashBlockDescription
        GenericModel.title = flashBlocks[id].flashBlockName
        return GenericModel.instance
    }

    fun getNumModels(): Int {
        return flashBlocks.size
    }

    fun getTitle(id: Int): String {
        return flashBlocks[id].flashBlockName
    }

    fun getDescription(id: Int): String {
        return flashBlocks[id].flashBlockDescription
    }
}