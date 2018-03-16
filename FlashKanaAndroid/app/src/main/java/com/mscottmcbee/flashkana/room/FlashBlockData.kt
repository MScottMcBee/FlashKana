package com.mscottmcbee.flashkana.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.ColumnInfo

@Entity(tableName = "FlashBlockData")

data class FlashBlockData(@PrimaryKey(autoGenerate = true) var id: Int?,
                          @ColumnInfo(name = "flashBlockName") var flashBlockName: String,
                          @ColumnInfo(name = "flashBlockDescription") var flashBlockDescription: String
) {
    constructor() : this(null, "", "")
}