package com.mscottmcbee.flashkana.model.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.ColumnInfo

@Entity(tableName = "LinkData")

data class LinkData(@PrimaryKey(autoGenerate = true) var id: Int?,
                    @ColumnInfo(name = "linkDataFlashBlockID") var linkDataFlashBlockID: Int?,
                    @ColumnInfo(name = "linkDataFlashCardID") var linkDataFlashCardID: Int?
) {
    constructor() : this(null, null, null)
}