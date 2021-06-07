package com.example.mvvm.mainActivity.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.mainActivity.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //view binding
        setContentView(binding.root) //attach root view with activity

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java) // initialize viewModel
        setLiveDataListeners()   //observe data changing
        viewModel.getImageList() //request for data whenever you need
    }

    private fun setLiveDataListeners() {
        viewModel.imageModelListLiveData.observe(this, { data ->
            Log.i("checkData", "setLiveDataListeners: ${data.size}")
        })

        viewModel.imageFailureLiveData.observe(this, {message ->
            Log.i("checkData", "setLiveDataListeners: $message")
        })

        viewModel.progressBarLiveData.observe(this, { isProgress ->
            if (isProgress){
                binding.progressBar.visibility = View.VISIBLE
            }else {
                binding.progressBar.visibility = View.GONE
            }
        })
    }
}