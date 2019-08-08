package main.kotlin.extensions

import main.kotlin.model.Veiculo
import java.util.regex.Pattern

fun Veiculo.placaFormatter(): String? {
    val regex = Pattern.compile("(\\w{3})(\\d{4})").toRegex()
    return placa?.replace(regex,"\$1-\$2")
}