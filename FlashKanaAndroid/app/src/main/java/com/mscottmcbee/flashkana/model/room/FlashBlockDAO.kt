package com.mscottmcbee.flashkana.model.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
interface FlashBlockDAO : BaseDAO<FlashBlockData> {

    @Query("SELECT * from FlashBlockData")
    fun getAll(): List<FlashBlockData>

    @Query("DELETE FROM FlashBlockData")
    fun deleteAll()

    @Query("SELECT COUNT(*) AS RowCnt from FlashBlockData")
    fun getSize(): Int

    @Query("SELECT * from FlashBlockData WHERE id=:flashBlockID")
    fun getFlashBlock(flashBlockID: Int): FlashBlockData

    @Query("SELECT id from FlashBlockData WHERE flashBlockName=:title")
    fun getIDByTitle(title: String): Int
}