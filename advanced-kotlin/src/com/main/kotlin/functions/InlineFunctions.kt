package com.main.kotlin.functions

 fun nonOp(x: Int) {

}

inline fun operation(op: () -> Unit) = run {
    println("Before 'op' function")
    op()
    println("After 'op' function")
}

fun anotherFunction() {
    operation { println("This is another function") }
}

fun main(args: Array<String>) {
    operation { println("This is 'op' function") }
}