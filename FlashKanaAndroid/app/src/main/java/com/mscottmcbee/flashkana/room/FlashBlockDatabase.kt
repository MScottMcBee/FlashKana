package com.mscottmcbee.flashkana.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


@Database(entities = arrayOf(FlashBlockData::class), version = 1)
abstract class FlashBlockDatabase : RoomDatabase(){

    abstract fun flashBlockDAO(): FlashBlockDAO

    /*companion object {
        var instance: FlashBlockDatabase? = null
        fun instantiate(context: Context): FlashBlockDatabase? {
            if (instance == null) {
                synchronized(FlashBlockDatabase::class) {
                    instance = Room.databaseBuilder(context,
                            FlashBlockDatabase::class.java, "FlashBlock.db")
                            .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }
    }*/
}