package com.mscottmcbee.flashkana.model.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = arrayOf(FlashBlockData::class, LinkData::class, FlashCardData::class), version = 1)
abstract class MasterDatabase : RoomDatabase() {
    abstract fun flashBlockDAO(): FlashBlockDAO
    abstract fun flashCardDAO(): FlashCardDAO
    abstract fun linkDAO(): LinkDAO
}