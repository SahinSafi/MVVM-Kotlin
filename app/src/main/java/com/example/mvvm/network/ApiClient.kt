package com.example.mvpinkotlin.network


import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val BASE_URL = "https://picsum.photos/"
    private var retrofit: Retrofit? = null
    private val gson = GsonBuilder().setLenient().create()

    val getClient: Retrofit get() {
        if (retrofit == null){
            synchronized(Retrofit::class.java){
                if (retrofit == null){
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()
                }
            }
        }
        return retrofit!!
    }
}

