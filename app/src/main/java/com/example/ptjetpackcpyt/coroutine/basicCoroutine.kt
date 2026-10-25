package com.example.ptjetpackcpyt.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

fun main() = runBlocking{
    print("Start")
    launch {
        delay(5000.milliseconds)
        println("Async Task Done")

    }

    println("End")

}