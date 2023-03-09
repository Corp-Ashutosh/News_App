package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapters.Rec1_adapter
import com.example.myapplication.model.Headlines
import com.example.myapplication.view_m.NewsViewModel

class MainActivity : AppCompatActivity() {
    lateinit var finaldata : List<Headlines>
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            val myApp = applicationContext as Newsapplication
            val db = myApp.database
            supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
            supportActionBar?.setCustomView(R.layout.heading_layout)
            Log.d("aj" , "main_act")
            val viewModel : NewsViewModel by viewModels()
            viewModel.initrepo(db)
            viewModel.get_db().observe(this , Observer {
                finaldata = it
                adaptercall() } )


        } private fun adaptercall() {
        val recyclerView = findViewById<RecyclerView>(R.id.rec_1)
        val adapter = Rec1_adapter(this, finaldata)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
//        adapter.notifyDataSetChanged()
    }

}