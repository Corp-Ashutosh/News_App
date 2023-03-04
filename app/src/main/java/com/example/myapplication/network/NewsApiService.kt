package com.example.myapplication.network

import com.example.myapplication.data.MainApiRequest
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
val api_key = "85c3a6657e6749a992431b8cec44da66"
val country = "IN"

private const val base_url ="https://newsapi.org/v2/"
//et your desired log level
// set your desired log level

interface NewsApiService{
    @GET("top-headlines")
    suspend fun getHeadlines(@Query("sources") county:String = "bbc-news", @Query("apiKey") apikey: String = api_key) : Response<MainApiRequest>
}
object NewsApi{
    var loggingInterceptor = HttpLoggingInterceptor()
    init {
        loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(loggingInterceptor)
        .build()
    val retrofit = Retrofit.Builder().client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(base_url).build()

    val retrofitService: NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }

}