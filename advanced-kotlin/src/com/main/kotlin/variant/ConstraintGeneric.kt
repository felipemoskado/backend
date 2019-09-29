package com.main.kotlin.variant

import java.math.BigDecimal

data class Employee(val salary: BigDecimal)

interface ConstraintGenerics<T> where T : Person {
    fun foo(data: T): String
}

fun main(args: Array<String>) {
    val person: ConstraintGenerics<Person>
    val physicalPerson: ConstraintGenerics<PhysicalPerson>
    val juridicPerson: ConstraintGenerics<JuridicPerson>

    // Error because "where" condition in type generic
    // val employee: ConstraintGenerics<Employee>
}