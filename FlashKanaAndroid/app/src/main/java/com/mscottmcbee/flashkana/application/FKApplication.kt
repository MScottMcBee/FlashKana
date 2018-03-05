package com.mscottmcbee.flashkana.application

import android.app.Application
import com.mscottmcbee.flashkana.model.HiraganaModel
import com.mscottmcbee.flashkana.model.KatakanaModel
import com.mscottmcbee.flashkana.model.ModelProvider

class FKApplication : Application() {

    override fun onCreate() {

        HiraganaModel.instance = HiraganaModel()
        KatakanaModel.instance = KatakanaModel()
        ModelProvider.instance = ModelProvider()

        super.onCreate()
    }
}