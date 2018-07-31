package com.mscottmcbee.flashkana.model.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update


interface BaseDAO<T> {

    @Insert(onConflict = REPLACE)
    fun insert(obj: T)

    @Insert(onConflict = REPLACE)
    fun insert(vararg obj: T)

    @Update
    fun update(obj: T)

    @Delete
    fun delete(obj: T)
}