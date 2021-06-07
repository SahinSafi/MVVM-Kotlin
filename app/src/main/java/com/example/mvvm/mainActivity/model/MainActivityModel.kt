package com.example.mvvm.mainActivity.model

import com.example.mvpinkotlin.network.ApiClient
import com.example.mvpinkotlin.network.ApiInterface
import com.example.mvpinkotlin.network.RequestCompleteListener
import com.example.mvvm.mainActivity.model.dataModel.ImageModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityModel {

    companion object {
        private val apiInterface: ApiInterface = ApiClient().getClient.create(ApiInterface::class.java)

        fun getImageList(callback: RequestCompleteListener<MutableList<ImageModel>>) {
            val call: Call<MutableList<ImageModel>> = apiInterface.getImageArray()
            call.enqueue(object : Callback<MutableList<ImageModel>> {
                override fun onResponse(
                    call: Call<MutableList<ImageModel>>,
                    response: Response<MutableList<ImageModel>>
                ) {
                    if (response.code() == 200) {
                        response.body()?.let { callback.onSuccess(it.toMutableList()) }
                    } else {
                        callback.onFailed(response.message())
                    }
                }

                override fun onFailure(call: Call<MutableList<ImageModel>>, t: Throwable) {
                    callback.onFailed(t.message.toString())
                }

            })
        }
    }


}