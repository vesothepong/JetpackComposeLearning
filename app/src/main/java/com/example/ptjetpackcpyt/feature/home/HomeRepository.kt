package com.example.ptjetpackcpyt.feature.home

class HomeRepository {
    suspend fun getMessage():String{
        return "This is my message."
    }
}