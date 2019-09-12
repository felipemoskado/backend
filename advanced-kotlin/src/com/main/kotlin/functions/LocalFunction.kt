package com.main.kotlin.functions

fun topFunction(param: String) {
    fun localFunction() {
        println("Parameter of topFunction: $param")
        println("No parameter on localFunction")
    }

    localFunction()
}

fun main(args: Array<String>) {
    topFunction("Hello World")
}