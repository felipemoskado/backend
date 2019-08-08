package main.kotlin.service

import main.kotlin.extensions.placaFormatter
import main.kotlin.model.Veiculo
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class VeiculoService {

    fun getAll(): List<Veiculo> = VEICULOS.map { it.copy(placa = it.placaFormatter()) }

    fun getOne(id: Long): Veiculo? {
        val veiculo = VEICULOS.firstOrNull { it.id == id }
        return veiculo?.copy(placa = veiculo.placaFormatter())
    }

    private fun lol() {
        VEICULOS.map {
            VEICULOS.mapIndexed { index, veiculo ->
                return@map
            }
        }
    }

    companion object {
        private val VEICULOS = listOf(
                Veiculo(id = 1L, placa = "QWE1234", ano = LocalDate.now()),
                Veiculo(id = 2L, placa = "ASD1234", ano = LocalDate.now()),
                Veiculo(id = 3L, ano = LocalDate.now())
        )
    }
}