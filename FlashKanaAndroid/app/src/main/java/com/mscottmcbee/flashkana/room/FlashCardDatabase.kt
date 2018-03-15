package com.mscottmcbee.flashkana.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


@Database(entities = arrayOf(FlashCardData::class), version = 1)
abstract class FlashCardDatabase : RoomDatabase(){

    abstract fun flashCardDAO(): FlashCardDAO

    companion object {
        var instance: FlashCardDatabase? = null
        fun instantiate(context: Context): FlashCardDatabase? {
            if (this.instance == null) {
                synchronized(FlashCardDatabase::class) {
                    instance = Room.databaseBuilder(context,
                            FlashCardDatabase::class.java, "FlashCard.db")
                            .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }
    }
}