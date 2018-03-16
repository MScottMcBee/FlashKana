package com.mscottmcbee.flashkana.application

import android.app.Application
import android.content.Context
import com.mscottmcbee.flashkana.model.*
import com.mscottmcbee.flashkana.room.DatabaseWrapper

class FKApplication : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        context = applicationContext
        DatabaseWrapper.instance = DatabaseWrapper()
        GenericModel.instance = GenericModel()
        ModelProvider.instance = ModelProvider(applicationContext)

        super.onCreate()
    }
}