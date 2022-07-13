package com.example.contactcard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query

@Dao
interface cardDao {
    @Query("SELECT * FROM cardData")
    fun getAll(): LiveData<List<cardData>>
    @Insert(onConflict = IGNORE)
    suspend fun insert(cardData: cardData)
}