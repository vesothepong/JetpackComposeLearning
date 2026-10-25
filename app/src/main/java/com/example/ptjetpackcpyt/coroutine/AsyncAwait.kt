package com.example.ptjetpackcpyt.coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

fun main(){
    runBlocking {
        val deferred = async {
            delay(5000.milliseconds)
            "Now you've been done!"
        }
        println("Waiting...")
        val result = deferred.await()
        println(result)

    }
}