package com.mscottmcbee.flashkana.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.ColumnInfo

@Entity(tableName = "FlashCardData")

data class FlashCardData(@PrimaryKey(autoGenerate = true) var id: Int?,
                         @ColumnInfo(name = "flashCardAnswer") var flashCardAnswer: String,
                         @ColumnInfo(name = "flashCardQuestion") var flashCardQuestion: String,
                         @ColumnInfo(name = "flashCardType") var flashCardType: String
) {
    constructor() : this(null, "", "", "")
}