package com.example.ptjetpackcpyt.coroutine

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

fun main(){
    runBlocking {
        val data = fetchData()
        println(data)
    }
}

/*
* Request to backend api
 */

suspend fun fetchData():String{
    delay(1000L.milliseconds)
    return "Hello world"
}