package com.mscottmcbee.flashkana.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


@Database(entities = arrayOf(LinkData::class), version = 1)
abstract class LinkDatabase : RoomDatabase(){

    abstract fun linkDAO(): LinkDAO

    companion object {
        var instance: LinkDatabase? = null
        fun instantiate(context: Context): LinkDatabase? {
            if (this.instance == null) {
                synchronized(LinkDatabase::class) {
                    instance = Room.databaseBuilder(context,
                            LinkDatabase::class.java, "Link.db")
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