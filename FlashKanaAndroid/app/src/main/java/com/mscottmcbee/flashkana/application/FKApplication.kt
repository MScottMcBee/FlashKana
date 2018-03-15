package com.mscottmcbee.flashkana.application

import android.app.Application
import com.mscottmcbee.flashkana.model.*
import com.mscottmcbee.flashkana.room.FlashBlockDatabase
import com.mscottmcbee.flashkana.room.FlashCardDatabase
import com.mscottmcbee.flashkana.room.LinkDatabase

class FKApplication : Application() {

    override fun onCreate() {


        /*HiraganaModel.instance = HiraganaModel()
        KatakanaModel.instance = KatakanaModel()
        TestingModel.instance = TestingModel()*/
        GenericModel.instance = GenericModel()
        ModelProvider.instance = ModelProvider(applicationContext)
        //ModelProvider.instance.emptyDB()
        ModelProvider.instance.default()

        super.onCreate()
    }
}