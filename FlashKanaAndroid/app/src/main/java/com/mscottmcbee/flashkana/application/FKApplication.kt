package com.mscottmcbee.flashkana.application

import android.app.Application
import com.mscottmcbee.flashkana.model.HiraganaModel
import com.mscottmcbee.flashkana.model.KatakanaModel
import com.mscottmcbee.flashkana.model.ModelProvider
import com.mscottmcbee.flashkana.model.TestingModel

class FKApplication : Application() {

    override fun onCreate() {

        HiraganaModel.instance = HiraganaModel()
        KatakanaModel.instance = KatakanaModel()
        TestingModel.instance = TestingModel()
        ModelProvider.instance = ModelProvider()

        super.onCreate()
    }
}