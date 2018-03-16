package com.mscottmcbee.flashkana.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
interface LinkDAO : BaseDAO<LinkData> {

    @Query("DELETE FROM LinkData")
    fun deleteAll()

    @Query("SELECT * from LinkData")
    fun getAll(): List<LinkData>

    @Query("SELECT * FROM LinkData WHERE linkDataFlashBlockID=:flashBlockID")
    fun getLinksByFlashBlockID(flashBlockID: Int?): List<LinkData>

}