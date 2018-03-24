package com.mscottmcbee.flashkana.application

import android.app.Application
import com.mscottmcbee.flashkana.model.*
import com.mscottmcbee.flashkana.model.room.DatabaseWrapper

class FKApplication : Application() {

    override fun onCreate() {
        DatabaseWrapper.instance = DatabaseWrapper(applicationContext)
        DatabaseWrapper.instance.emptyDatabase()
        DatabaseWrapper.instance.defaultDatabase()
        ModelProvider.instance = ModelProvider()
        super.onCreate()
    }
}