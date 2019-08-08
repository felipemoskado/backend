package main.kotlin.controller

import main.kotlin.model.Veiculo
import main.kotlin.service.VeiculoService
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("veiculos")
class VeiculoController(private val service: VeiculoService) {

    @GetMapping(produces = [APPLICATION_JSON_VALUE])
    fun getAll(): List<Veiculo> = service.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable("id") id: Long): Veiculo =
            service.getOne(id) ?: throw ResponseStatusException(NOT_FOUND, "Veículo não encontrado")
}