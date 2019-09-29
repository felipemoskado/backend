package com.main.kotlin.variant

/**
 * Variance annotation (@annotation out)
 *
 * Allows objects the same type or more specifics.
 *
 * When keyword "in" is used, the "T" object just can be "consumed", never "produced"
 */
interface ContravariantSource<in T> {
    fun foo(data: T): String
}

fun demoContravariant(source: ContravariantSource<Number>) {
    // Compile error
//    val objects1: ContravariantSource<Any> = source

    // Ok
    val objects: ContravariantSource<Long> = source
}

fun demoContravariant2(strs: Source<Long>) {
    // Ok
    val objects: Source<Any> = strs
    val objects2: Source<Number> = strs
}

interface Contravariant<in PhysicalPerson>

class ContravariantImpl : Contravariant<PhysicalPerson>

fun getContravariant(person: Contravariant<PhysicalPerson>) {
    val contravariant: Contravariant<PhysicalPerson2> = person

//    Error because Covariance interface uses "<out Person>" parameter
//    val contravariant: Contravariant<Person> = person
}

fun main(args: Array<String>) {
    getContravariant(ContravariantImpl())
}
