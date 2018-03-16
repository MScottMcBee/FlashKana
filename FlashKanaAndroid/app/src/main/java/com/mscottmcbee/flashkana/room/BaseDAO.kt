package com.mscottmcbee.flashkana.room

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Update

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