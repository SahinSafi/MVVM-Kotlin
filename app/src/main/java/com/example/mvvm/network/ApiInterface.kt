package com.example.mvpinkotlin.network

import com.example.mvvm.mainActivity.model.dataModel.ImageModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2/list")
    fun getImageArray(): Call<MutableList<ImageModel>>
}