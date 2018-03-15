package com.mscottmcbee.flashkana.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao
interface FlashBlockDAO {

    @Query("SELECT * from FlashBlockData")
    fun getAll(): List<FlashBlockData>

    @Insert(onConflict = REPLACE)
    fun insert(flashBlockData: FlashBlockData)

    @Query("DELETE FROM FlashBlockData")
    fun deleteAll()

    @Query("SELECT COUNT(*) AS RowCnt from FlashBlockData")
    fun getSize(): Int

    @Query("SELECT * from FlashBlockData WHERE id=:flashBlockID")
    fun getFlashBlock(flashBlockID: Int): FlashBlockData

    @Query("SELECT id from FlashBlockData WHERE flashBlockName=:title")
    fun getIDByTitle(title: String): Int
}