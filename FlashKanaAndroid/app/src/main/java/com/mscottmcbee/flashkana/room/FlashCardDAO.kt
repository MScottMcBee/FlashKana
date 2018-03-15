package com.mscottmcbee.flashkana.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao
interface FlashCardDAO {

    @Insert(onConflict = REPLACE)
    fun insert(flashcardData: FlashCardData)

    @Query("DELETE from FlashCardData")
    fun deleteAll()

    @Query("SELECT * from FlashCardData")//TODO
    fun getAll(): List<FlashCardData>

    @Query("SELECT * from FlashCardData WHERE id=:flashCardID")//TODO this one first
    fun getFlashCard(flashCardID: Int?): FlashCardData

    @Query("SELECT id from FlashCardData WHERE flashCardQuestion=:flashCardQuestion")
    fun getIDByQuestion(flashCardQuestion: String): Int

    @Query("SELECT id from FlashCardData WHERE flashCardAnswer=:flashCardAnswer")
    fun getIDByAnswer(flashCardAnswer: String): Int

    @Query("SELECT id from FlashCardData WHERE flashCardType=:flashCardType")
    fun getIDByType(flashCardType: String): List<Int>

    /*@Query("SELECT * from FlashCardData")//TODO
    fun getFlashCardsFromIDs(flashCardIDs: List<Int>): List<FlashCardData>

    @Query("SELECT * from FlashCardData")//TODO
    fun containsAnswer(answer: String): Boolean

    @Query("SELECT * from FlashCardData")//TODO
    fun containsQuestion(question: String): Boolean

    @Query("SELECT * from FlashCardData")//TODO
    fun getFlashCardsByType(type: String): List<FlashCardData>

    @Query("SELECT * from FlashCardData")//TODO
    fun getIDOfAnswer(answer: String): Int

    @Query("SELECT * from FlashCardData")//TODO
    fun getIDOfQuestion(answer: String): Int*/
}