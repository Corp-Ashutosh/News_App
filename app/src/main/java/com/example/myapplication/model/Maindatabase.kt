package com.example.myapplication.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.model.Headlines
import com.example.myapplication.model.HeadlinesDao


@Database(entities = [Headlines :: class] , version = 1 , exportSchema = false)
abstract class  Maindatabase :RoomDatabase() {
    abstract fun headlinesDao(): HeadlinesDao

    companion object {
        @Volatile
        private var Instance: Maindatabase? = null


        fun getDatabase(context:Context): Maindatabase {
            return Instance ?: synchronized(this) {
                val instance =
                    Room.databaseBuilder(context, Maindatabase::class.java, "news_database")
                        .fallbackToDestructiveMigration().build()
                Instance = instance
                return instance
            }


        }
    }
}