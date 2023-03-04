package com.example.myapplication.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.myapplication.model.Headlines
import com.example.myapplication.model.Maindatabase
import com.example.myapplication.network.NewsApi.retrofitService

class NewsRepository(private var database : Maindatabase) {
    suspend fun saveNewsHeadlines()
    {
        Log.d("aj" , "repo__")
        val response = retrofitService.getHeadlines("bbc-news" , "85c3a6657e6749a992431b8cec44da66")
        if(response.isSuccessful)
        {  Log.d("aj" , "sucess__")
            val articles = response.body()?.articles
            if (articles != null) {
                Log.d("aj" , articles.size.toString())
            }
            var cnt = 1
            if(articles!=null) {
                for (article in articles) {

                    Log.d("aj", article?.title ?: "a")
                    database.headlinesDao().insert(
                        Headlines(
                            cnt,
                            article?.author ?: "a",
                            article?.title ?: "a",
                            article?.description ?: "a",
                            article?.url ?: "a",
                            article?.urlToImage ?: "a",
                            article?.publishedAt ?: "a",
                            article?.content ?: "b"
                        )
                    )
                    cnt++

                }
                // database.headlinesDao().insert(articles)
            }
        }
        else
        {    Log.d("aj" , "aPI REQEUEST FAILED ")
            Log.e("es" , "aPI REQEUEST FAILED ")
        }
    }
    fun return_db() : LiveData<List<Headlines>> {
        return database.headlinesDao().getAllHeadlines()
    }
}