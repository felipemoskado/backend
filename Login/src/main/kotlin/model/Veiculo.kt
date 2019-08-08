package main.kotlin.model

import java.time.LocalDate

data class Veiculo(val id: Long, val placa: String? = null, val ano: LocalDate)