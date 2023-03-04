package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Headlines")
data class Headlines(
    @PrimaryKey(autoGenerate = false)
    var cnt :Int ,
    var author:String ,
    var title :String ,
    var description :String ,
    val url :String ,
    val urlToImage:String  ,
    val publishedAt :String ,
    val content :String
)