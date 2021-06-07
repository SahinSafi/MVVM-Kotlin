package com.example.mvpinkotlin.network

interface RequestCompleteListener<T> {
    fun onSuccess(data: T)
    fun onFailed(message: String)
}