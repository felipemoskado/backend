package com.main.kotlin.delegations

import kotlin.properties.Delegates

class User {

    // When assigned the function is executed
    var name: String by Delegates.observable("<no name>") { prop, old, new ->
        println("$prop : $old -> $new")
    }

    // Assigns just when condition is true
    var age: Int by Delegates.vetoable(23) { prop, old, new -> old == new }
}

fun main() {
    val user = User()
    user.name = "first"
    user.name = "second"
    user.name = "third"

    user.age = 23
    println(user.age)

    user.age = 24
    println(user.age)
}