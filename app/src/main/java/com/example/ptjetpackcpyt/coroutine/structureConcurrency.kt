package com.example.ptjetpackcpyt.coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds



fun main(){
    runBlocking{
     coroutineScope {
        launch {
            delay(5000.milliseconds)
            println("Task 1")
        }
         launch {
             delay(5000.milliseconds)
             println("Task 2")
         }
         launch {
             delay(2000.milliseconds)
             println("Task 3")
         }

     }
    }
}