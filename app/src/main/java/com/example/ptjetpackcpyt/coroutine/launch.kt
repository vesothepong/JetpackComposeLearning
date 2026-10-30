package com.example.ptjetpackcpyt.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking{
        println("Application start")
        val job = launch {
            delay(2000L)
            println("Application finished")
        }
        delay(4000L)
        job.cancel()
    }
}