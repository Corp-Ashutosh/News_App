package com.example.myapplication.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HeadlinesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(headline : Headlines)
    @Update
    suspend fun update(headline: Headlines)
    @Delete
    suspend fun delete(headline: Headlines)
    @Query("Select * From Headlines")
    fun getAllHeadlines() :LiveData<List<Headlines>>
}