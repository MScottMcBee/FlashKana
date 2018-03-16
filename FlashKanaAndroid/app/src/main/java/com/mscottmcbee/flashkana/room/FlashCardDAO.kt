package com.mscottmcbee.flashkana.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
interface FlashCardDAO : BaseDAO<FlashCardData> {

    @Query("DELETE from FlashCardData")
    fun deleteAll()

    @Query("SELECT * from FlashCardData")
    fun getAll(): List<FlashCardData>

    @Query("SELECT * from FlashCardData WHERE id=:flashCardID")
    fun getFlashCard(flashCardID: Int?): FlashCardData

    @Query("SELECT * from FlashCardData WHERE id IN (:flashCardIDs)")
    fun getFlashCards(flashCardIDs: List<Int?>): List<FlashCardData>

    @Query("SELECT id from FlashCardData WHERE flashCardQuestion=:flashCardQuestion")
    fun getIDByQuestion(flashCardQuestion: String): Int

    @Query("SELECT id from FlashCardData WHERE flashCardAnswer=:flashCardAnswer")
    fun getIDByAnswer(flashCardAnswer: String): Int

    @Query("SELECT id from FlashCardData WHERE flashCardType=:flashCardType")
    fun getIDByType(flashCardType: String): List<Int>
}