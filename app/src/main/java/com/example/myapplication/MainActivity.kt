package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.myapplication.view_m.NewsViewModel

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            val myApp = applicationContext as Newsapplication

            val db = myApp.database


            Log.d("aj" , "main_act")
            val viewModel : NewsViewModel by viewModels()
            viewModel.initrepo(db)
            viewModel.get_db().observe(this , Observer { findViewById<TextView>(R.id.text1).text =it[0].author } )

        }
}