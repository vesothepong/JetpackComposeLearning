package com.example.ptjetpackcpyt.feature.home

class HomeRepository {
    private val messageList = (1..100).map{
        "This is my message $it"
    }

    suspend fun getMessage(): List<String>{
        return messageList
    }
}