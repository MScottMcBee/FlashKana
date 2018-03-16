package com.mscottmcbee.flashkana.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase


@Database(entities = arrayOf(FlashBlockData::class, LinkData::class, FlashCardData::class), version = 1)
abstract class MasterDatabase : RoomDatabase() {
    abstract fun flashBlockDAO(): FlashBlockDAO
    abstract fun flashCardDAO(): FlashCardDAO
    abstract fun linkDAO(): LinkDAO
}