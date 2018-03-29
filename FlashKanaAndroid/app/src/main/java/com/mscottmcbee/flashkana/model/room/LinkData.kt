package com.mscottmcbee.flashkana.model.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.ColumnInfo

@Entity(tableName = "LinkData")

data class LinkData(@PrimaryKey(autoGenerate = true) var id: Int? = null,
                    @ColumnInfo(name = "linkDataFlashBlockID") var linkDataFlashBlockID: Int? = null,
                    @ColumnInfo(name = "linkDataFlashCardID") var linkDataFlashCardID: Int? = null,
                    @ColumnInfo(name = "linkDataFlashCardScore") var linkDataFlashCardScore: Int? = 0
) {
    constructor(flashBlockID: Int?, flashCardID: Int?) : this(null, flashBlockID, flashCardID, 0)
    constructor(flashBlockID: Int?, flashCardID: Int?, score: Int?) : this(null, flashBlockID, flashCardID, score)
}