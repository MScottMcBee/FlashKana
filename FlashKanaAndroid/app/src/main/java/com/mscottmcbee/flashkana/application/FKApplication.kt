package com.mscottmcbee.flashkana.application

import androidx.multidex.MultiDexApplication
import org.koin.android.ext.android.startKoin

class FKApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(fkModules))
    }
}