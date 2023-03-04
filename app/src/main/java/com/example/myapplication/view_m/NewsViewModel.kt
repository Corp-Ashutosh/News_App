package com.example.myapplication.view_m

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Repository.NewsRepository
import com.example.myapplication.model.Headlines
import com.example.myapplication.model.Maindatabase
import kotlinx.coroutines.launch

class NewsViewModel():ViewModel() {
    private  lateinit var newsRepo: NewsRepository
    fun initrepo(db: Maindatabase) {
        newsRepo = NewsRepository(db)
        Log.d("aj", "init")
        viewModelScope.launch {
            newsRepo.saveNewsHeadlines()
        }
    }
private lateinit  var obv_data : LiveData<List<Headlines>>

    fun get_db() :LiveData<List<Headlines>>{
        viewModelScope.launch {
            newsRepo.saveNewsHeadlines()
        }
       obv_data = newsRepo.return_db()
        return obv_data
    }



}