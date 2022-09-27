package com.example.noteapp.kotlin

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking

fun main() {
    val flow = flow {
        for (i in 1..30) {
            delay(1000)
            emit(i)
        }
    }

    runBlocking {
        val result = flow.conflate().toList()
        println(result)
    }
}