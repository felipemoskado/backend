package com.main.kotlin.variant

/**
 * Variance annotation (@annotation out)
 *
 * Allows objects the same type or more generics
 */
interface Source<out T>

fun demo(strs: Source<Number>) {
    // Compile error
    // val objects: Source<Long> = strs

    // Ok
     val objects: Source<Any> = strs
}

fun demo2(strs: Source<Long>) {
    // Ok
    val objects: Source<Any> = strs
    val objects2: Source<Number> = strs
}

open class Person(val id: Long = 1L, val name: String = "Pé de pano")

open class PhysicalPerson(val cpf: String = "123.456.789-00") : Person()

open class PhysicalPerson2(val age: Int = 23) : PhysicalPerson()

data class JuridicPerson(val cnpj: String = ""): Person()

interface Covariance<out PhysicalPerson2>

class CovarianceImpl : Covariance<PhysicalPerson2>

fun getCovariance(person: Covariance<PhysicalPerson2>) {
    val covariance: Covariance<Person> = person

//    Error because Covariance interface uses "<out Person>" parameter
    val covarianceError: Covariance<PhysicalPerson> = person
}

fun main(args: Array<String>) {
    getCovariance(CovarianceImpl())
}
