package com.main.kotlin.delegations

var count = 0

val lazyValue: String by lazy {
    println("computed!")
    count++
    "Hello"
}

fun main() {
    println(lazyValue)
    println(lazyValue)
}