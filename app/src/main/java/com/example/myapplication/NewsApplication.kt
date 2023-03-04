package com.example.myapplication

import android.app.Application
import com.example.myapplication.model.Maindatabase
import com.example.myapplication.model.Maindatabase.Companion.getDatabase

class Newsapplication : Application() {

    val database : Maindatabase by lazy { Maindatabase.getDatabase(this) }

}