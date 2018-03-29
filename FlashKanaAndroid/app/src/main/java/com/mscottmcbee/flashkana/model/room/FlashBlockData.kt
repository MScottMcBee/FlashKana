package com.mscottmcbee.flashkana.model.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.ColumnInfo

@Entity(tableName = "FlashBlockData")

data class FlashBlockData(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                          @ColumnInfo(name = "flashBlockName") var flashBlockName: String = "",
                          @ColumnInfo(name = "flashBlockDescription") var flashBlockDescription: String = "",
                          @ColumnInfo(name = "flashBlockStatViewed") var flashBlockStatViewed: Int = 0,
                          @ColumnInfo(name = "flashBlockStatQuizzed") var flashBlockStatQuizzed: Int = 0

) {
    constructor(name: String, description: String) : this(0, name, description, 0, 0)
}