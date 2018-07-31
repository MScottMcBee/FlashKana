package com.mscottmcbee.flashkana.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "FlashCardData")

data class FlashCardData(@PrimaryKey(autoGenerate = true) var id: Int? = null,
                         @ColumnInfo(name = "flashCardAnswer") var flashCardAnswer: String = "",
                         @ColumnInfo(name = "flashCardQuestion") var flashCardQuestion: String = "",
                         @ColumnInfo(name = "flashCardType") var flashCardType: String = ""
) {
    constructor(answer: String, question: String, type: String) : this(null, answer, question, type)
}