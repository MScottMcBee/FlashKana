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

    @Query("SELECT flashBlockStatViewed from FlashBlockData WHERE id=:flashBlockID")
    fun getStatViewed(flashBlockID: Int): Int

    @Query("SELECT flashBlockStatQuizzed from FlashBlockData WHERE id=:flashBlockID")
    fun getStatQuizzed(flashBlockID: Int): Int

    @Query("UPDATE FlashBlockData SET flashBlockStatViewed= :cardsViewed WHERE id=:flashBlockID")
    fun updateStatViewed(flashBlockID: Int, cardsViewed: Int)

    @Query("UPDATE FlashBlockData SET flashBlockStatQuizzed= :cardsQuizzed WHERE id=:flashBlockID")
    fun updateStatQuizzed(flashBlockID: Int, cardsQuizzed: Int)

}