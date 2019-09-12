package com.main.kotlin.functions

fun operation(value: Int, op: (Int) -> Int): Int = op(value)

fun main(args: Array<String>) {
    val anonymousFunction = fun(x: Int): Int = x * x
    operation(10, anonymousFunction)
    operation(10, fun(x: Int): Int = x * x)
}