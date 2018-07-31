package com.mscottmcbee.flashkana.model.room


import androidx.room.ColumnInfo
import androidx.room.Entity

import androidx.room.PrimaryKey

@Entity(tableName = "LinkData")

data class LinkData(@PrimaryKey(autoGenerate = true) var id: Int? = null,
                    @ColumnInfo(name = "linkDataFlashBlockID") var linkDataFlashBlockID: Int? = null,
                    @ColumnInfo(name = "linkDataFlashCardID") var linkDataFlashCardID: Int? = null,
                    @ColumnInfo(name = "linkDataFlashCardScore") var linkDataFlashCardScore: Int? = 0
) {
    constructor(flashBlockID: Int?, flashCardID: Int?) : this(null, flashBlockID, flashCardID, 0)
    constructor(flashBlockID: Int?, flashCardID: Int?, score: Int?) : this(null, flashBlockID, flashCardID, score)
}