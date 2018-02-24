package com.mscottmcbee.flashkana.application

import android.app.Application
import android.util.Log

class FKApplication : Application() {

    override fun onCreate() {

        Log.d("kill me","Oh hello :)")
        super.onCreate()
    }
}