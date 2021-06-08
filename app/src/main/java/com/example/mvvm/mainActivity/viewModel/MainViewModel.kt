package com.example.mvvm.mainActivity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvpinkotlin.network.RequestCompleteListener
import com.example.mvvm.mainActivity.model.MainActivityModel
import com.example.mvvm.mainActivity.model.dataModel.ImageModel

class MainViewModel : ViewModel() {

    var imageModelListLiveData = MutableLiveData<MutableList<ImageModel>>()
    var imageFailureLiveData = MutableLiveData<String>()
    var progressBarLiveData = MutableLiveData<Boolean>()

    fun getImageList() {
        progressBarLiveData.postValue(true)
        MainActivityModel.getImageList(object : RequestCompleteListener<MutableList<ImageModel>> {
            override fun onSuccess(data: MutableList<ImageModel>) {
                imageModelListLiveData.postValue(data)
                progressBarLiveData.postValue(false)
            }

            override fun onFailed(message: String) {
                imageFailureLiveData.postValue(message)
                progressBarLiveData.postValue(false)
            }

        })
    }

}