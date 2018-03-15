package com.mscottmcbee.flashkana.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao
interface LinkDAO {

    @Insert(onConflict = REPLACE)
    fun insert(linkData: LinkData)

    @Query("DELETE FROM LinkData")
    fun deleteAll()

    @Query("SELECT * from LinkData")
    fun getAll(): List<LinkData>

    @Query("SELECT * FROM LinkData WHERE linkDataFlashBlockID=:flashBlockID")//TODO this one first
    fun getLinksByFlashBlockID(flashBlockID: Int?): List<LinkData>

    /*@Query("SELECT * from LinkData")//TODO
    fun getLinksByFlashCardID(flashCardID: Int): List<LinkData>*/

}