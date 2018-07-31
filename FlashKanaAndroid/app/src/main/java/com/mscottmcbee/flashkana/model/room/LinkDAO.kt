package com.mscottmcbee.flashkana.model.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface LinkDAO : BaseDAO<LinkData> {

    @Query("DELETE FROM LinkData")
    fun deleteAll()

    @Query("SELECT * from LinkData")
    fun getAll(): List<LinkData>

    @Query("SELECT * FROM LinkData WHERE linkDataFlashBlockID=:flashBlockID")
    fun getLinksByFlashBlockID(flashBlockID: Int?): List<LinkData>

    @Query("SELECT linkDataFlashCardScore FROM LinkData WHERE linkDataFlashBlockID=:flashBlockID")
    fun getScores(flashBlockID: Int?): List<Int>

    @Query("SELECT linkDataFlashCardScore FROM LinkData WHERE linkDataFlashBlockID=:flashBlockID and linkDataFlashCardID=:flashCardID")
    fun getCardScore(flashBlockID: Int?, flashCardID: Int): Int

    @Query("UPDATE LinkData SET linkDataFlashCardScore= :flashCardScore WHERE linkDataFlashBlockID=:flashBlockID and linkDataFlashCardID=:flashCardID")
    fun updateCardScore(flashBlockID: Int?, flashCardID: Int, flashCardScore: Int)

}