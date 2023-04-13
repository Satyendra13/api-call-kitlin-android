package com.example.dropaline

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

val BASE_URL = "https://newsapi.org/"
const val API_KEY = "5a1a5edbd3dd42b198167c31635bfe51"

interface NewsInterface{

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country:String, @Query("page") page: Int): Call<News>

}


object NewsService{
    var newsInstances: NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        newsInstances = retrofit.create(NewsInterface::class.java)
    }
}