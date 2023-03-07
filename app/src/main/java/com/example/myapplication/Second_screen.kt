package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class Second_screen :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        val titleNews: TextView = findViewById(R.id.title_2)
        val authorNews: TextView = findViewById(R.id.author2)
        val dateNews: TextView = findViewById(R.id.date2)
        val contentNews: TextView = findViewById(R.id.content2)
        val imageNews: ImageView = findViewById(R.id.imageView2)


        val bundle: Bundle?= intent.extras
        val title1 =bundle!!.getString("title")
        val author1 = bundle.getString("author")
        val date1 = bundle.getString("date")
        val content1 = bundle.getString("content")
        val imageURl = bundle.getString("urlToImage")

        titleNews.text= title1
        authorNews.text= author1
        dateNews.text=date1
        contentNews.text=content1
        Glide.with(imageNews).load(imageURl).into(imageNews)


//Back Button
        val backButton = findViewById<Button>(R.id.backbutton)
        backButton.setOnClickListener {
            super.onBackPressed()
    }

}}
