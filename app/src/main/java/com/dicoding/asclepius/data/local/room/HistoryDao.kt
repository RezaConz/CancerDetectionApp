package com.dicoding.asclepius.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dicoding.asclepius.data.local.entity.History

@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(history: History)

    @Update
    fun update(history: History)

    @Delete
    fun delete(history: History)

    @Query("SELECT  * from History")
    fun getAllHistory(): LiveData<List<History>>

}