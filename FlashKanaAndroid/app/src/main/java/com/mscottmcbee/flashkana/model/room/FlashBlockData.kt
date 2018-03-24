package com.mscottmcbee.flashkana.model.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.ColumnInfo

@Entity(tableName = "FlashBlockData")

data class FlashBlockData(@PrimaryKey(autoGenerate = true) var id: Int,
                          @ColumnInfo(name = "flashBlockName") var flashBlockName: String,
                          @ColumnInfo(name = "flashBlockDescription") var flashBlockDescription: String,
                          @ColumnInfo(name = "flashBlockStatViewed") var flashBlockStatViewed: Int,
                          @ColumnInfo(name = "flashBlockStatQuizzed") var flashBlockStatQuizzed: Int

) {
    constructor() : this(0, "", "", 0, 0)
}