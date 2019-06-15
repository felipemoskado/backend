package helper

import java.util.*
import kotlin.math.absoluteValue

object RandomTest {

    fun positiveLong(): Long = Random().nextLong().absoluteValue

    fun generateString(): String = Random().nextLong().toString()

}