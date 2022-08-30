package com.example.test

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*

fun main() {
    println("Hello World!")

    val timestamp = Date().time
    val date = Date(timestamp)
    println(timestamp)
    println(date)

    val now = LocalDateTime.now()
    println(now)
}
